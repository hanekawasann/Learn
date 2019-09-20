package com.yukms.learn.tool;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class FileCompare {
    public static void main(String[] args) throws IOException {
        String comparePath = "lang\\annotation";
        compare(JDKFilePath.JDK7(comparePath), JDKFilePath.JDK8(comparePath));
    }

    public static void compare(FilePath filePath1, FilePath filePath2) {
        Map<String, String> compareMap = new TreeMap<>(Comparator.comparing(String::toString));
        compareMap.putAll(toMap(filePath1));
        List<File> files = listFilesSortByName(filePath2.getFile());
        for (File file : files) {
            String name = file.getName();
            if (compareMap.containsKey(name)) {
                compareMap.put(name, getBlankWithSameLength(filePath1));
            } else {
                compareMap.put(name, filePath2.getMark());
            }
        }
        printf(compareMap);
    }

    private static String getBlankWithSameLength(FilePath filePath1) {
        return filePath1.getMark().replaceAll(".{1}", " ");
    }

    private static void printf(Map<String, String> map) {
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getValue() + "\t" + entry.getKey());
        }
    }

    private static Map<String, String> toMap(FilePath filePath) {
        List<File> files = listFilesSortByName(filePath.getFile());
        return files.stream().collect(Collectors.toMap(File::getName, file -> filePath.getMark()));
    }

    private static List<File> listFilesSortByName(File file) {
        File[] files = file.listFiles();
        if (files == null) {
            return Collections.EMPTY_LIST;
        }
        Arrays.sort(files, Comparator.comparing(File::getName));
        return Arrays.asList(files);
    }
}
