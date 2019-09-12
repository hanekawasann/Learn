package com.yukms.learn.tool;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/9/12 11:41
 */
public class UpdatePackage {
    private enum JavaSourceCodeUpdater {
        VERSION_7("_07\\java",//
            new String[] { "package java\\.", "import java\\." },//
            new String[] { "package _07\\.java\\.", "import _07\\.java\\." }),
        VERSION_9("_08\\java",//
            new String[] { "package java\\.", "import java\\." },//
            new String[] { "package _08\\.java\\.", "import _08\\.java\\." });

        private String path;
        private String[] oldStrs;
        private String[] newStrs;

        JavaSourceCodeUpdater(String path, String[] oldStrs, String[] newStrs) {
            this.path = path;
            this.oldStrs = oldStrs;
            this.newStrs = newStrs;
            assert oldStrs.length == newStrs.length;
        }

        private static final String UTF_8 = "UTF-8";

        String updateLine(String line) {
            if (StringUtils.isBlank(line)) {
                return line;
            }
            int length = oldStrs.length;
            for (int i = 0; i < length; i++) {
                line = line.replaceAll(oldStrs[i], newStrs[i]);
            }
            return line;
        }

        static JavaSourceCodeUpdater of(String filePath) {
            for (JavaSourceCodeUpdater parse : values()) {
                if (filePath.contains(parse.path)) {
                    return parse;
                }
            }
            return null;
        }

        static void updateSourceFile(File file) {
            JavaSourceCodeUpdater updater = of(file.getAbsolutePath());
            if (updater == null) {
                return;
            }
            try {
                List<String> lines = FileUtils.readLines(file, UTF_8);
                ListIterator<String> iterator = lines.listIterator();
                while (iterator.hasNext()) {
                    String line = iterator.next();
                    iterator.set(updater.updateLine(line));
                }
                FileUtils.writeLines(file, UTF_8, lines, false);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(file);
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("");
        updateFile(file);
    }

    private static void updateFile(File file) {
        if (file.isDirectory()) {
            File[] childFiles = file.listFiles();
            if (childFiles == null) {
                return;
            }
            for (File childFile : childFiles) {
                updateFile(childFile);
            }
        } else {
            JavaSourceCodeUpdater.updateSourceFile(file);
        }
    }
}
