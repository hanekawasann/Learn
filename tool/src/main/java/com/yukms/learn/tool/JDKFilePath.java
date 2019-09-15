package com.yukms.learn.tool;

import java.io.File;
import java.io.IOException;

public class JDKFilePath implements FilePath {
    private final String mark;
    private final File file;

    private JDKFilePath(String mark, String projectName, String comparePath) throws IOException {
        this.mark = mark;
        this.file = new File(getParentProjectPath() + "\\" + projectName + "\\src\\java\\" + comparePath);
    }

    public static JDKFilePath JDK7(String comparePath) throws IOException {
        return new JDKFilePath("JDK7", "sourcecode7", comparePath);
    }

    public static JDKFilePath JDK8(String comparePath) throws IOException {
        return new JDKFilePath("JDK8", "sourcecode8", comparePath);
    }

    private static String getParentProjectPath() throws IOException {
        File file = new File("");
        return file.getCanonicalPath();
    }

    @Override
    public String getMark() {
        return mark;
    }

    @Override
    public File getFile() {
        return file;
    }
}
