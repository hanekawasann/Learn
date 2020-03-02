package com.yukms.learn.tool;

import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * @author hudingpeng hudingpeng@souche.com 2020/3/2 16:17
 */
public final class SqlBuilder {
    private static final Pattern TABLE_NAME_PATTERN = Pattern.compile("(?<=CREATE TABLE `)\\w+(?=` \\()");
    private static final Pattern KEY_NAME_PATTERN = Pattern.compile("(?<= {2}PRIMARY KEY \\(`)\\w+(?=`\\))");
    private static final Pattern COLUMN_NAME_PATTERN = Pattern.compile("(?<= {2}`)\\w+(?=` \\w+)");
    private static final String COLUMN_NAME_SPLIT = "_";
    private static final Pattern COLUMN_NAME_SPLIT_PATTERN = Pattern.compile(COLUMN_NAME_SPLIT + "\\w+");
    private static final String SAVE_OR_UPDATE_BATCH_FORMAT =
        "<insert id=\"saveOrUpdateBatch\" parameterType=\"java.util.List\" keyColumn=\"{0}\">\n"//
            + "\tINSERT INTO `{1}`\n"//
            + "\t(\n" //
            + "{2}"//
            + "\t)\n"//
            + "\tVALUES\n"//
            + "\t<foreach collection=\"list\" item=\"item\" separator=\",\">\n"//
            + "\t\t(\n"//
            + "{3}" //
            + "\t\t)\n"//
            + "\t</foreach>\n"//
            + "\tON DUPLICATE KEY UPDATE\n"//
            + "{4}"//
            + "</insert>";
    private final String ddl;
    private final String tableName;
    private final String keyName;
    private final List<String> columnNames;

    public SqlBuilder(String ddl) {
        if (StringUtils.isBlank(ddl)) {
            throw new IllegalArgumentException("ddl must't blank");
        }
        this.ddl = ddl;
        this.tableName = getTableName(ddl);
        this.columnNames = getColumnNames(ddl);
        this.keyName = getKeyName(ddl);
    }

    public String getSaveOrUpdateBatchSql() {
        StringBuilder insertPart = new StringBuilder();
        StringBuilder valuePart = new StringBuilder();
        StringBuilder updatePart = new StringBuilder();
        for (String columnName : columnNames) {
            insertPart.append("\t`").append(columnName).append("`,\n");
            String fieldName = underline2CamelCase(columnName);
            valuePart.append("\t\t#{item.").append(fieldName).append("},\n");
            if (columnName.equals(keyName)) {
                continue;
            }
            updatePart.append("\t`").append(columnName).append("`=VALUES(").append(fieldName).append("),\n");
        }
        removeLastComma(insertPart);
        removeLastComma(valuePart);
        removeLastComma(updatePart);
        return MessageFormat.format(SAVE_OR_UPDATE_BATCH_FORMAT, keyName, tableName, insertPart, valuePart, updatePart);
    }

    private void removeLastComma(StringBuilder sb) {
        int index = sb.length() - 1;
        sb.delete(index - 1, index);
    }

    private String underline2CamelCase(String s) {
        String newS = s;
        Matcher matcher = COLUMN_NAME_SPLIT_PATTERN.matcher(s);
        while (matcher.find()) {
            String group = matcher.group();
            newS = matcher.replaceAll(toWordWithFirstUpperCaseLetter(group));
            matcher = COLUMN_NAME_SPLIT_PATTERN.matcher(newS);
        }
        return newS;
    }

    private String toWordWithFirstUpperCaseLetter(String word) {
        String withoutUnderline = word;
        if (word.startsWith(COLUMN_NAME_SPLIT)) {
            withoutUnderline = withoutUnderline.substring(1);
        }
        String firstLetter = withoutUnderline.substring(0, 1);
        return firstLetter.toUpperCase() + withoutUnderline.substring(1);
    }

    private String getTableName(String ddl) {
        Matcher matcher = TABLE_NAME_PATTERN.matcher(ddl);
        if (matcher.find()) {
            return matcher.group();
        }
        throw new IllegalArgumentException("ddl");
    }

    private String getKeyName(String ddl) {
        Matcher matcher = KEY_NAME_PATTERN.matcher(ddl);
        if (matcher.find()) {
            return matcher.group();
        }
        throw new IllegalArgumentException("ddl");
    }

    private List<String> getColumnNames(String ddl) {
        List<String> columnNames = new LinkedList<>();
        Matcher matcher = COLUMN_NAME_PATTERN.matcher(ddl);
        while (matcher.find()) {
            columnNames.add(matcher.group());
        }
        return columnNames;
    }
}
