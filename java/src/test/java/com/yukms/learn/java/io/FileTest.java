package com.yukms.learn.java.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/10/15 11:02
 */
public class FileTest {
    @Test
    public void test_new() throws IOException {
        File file = new File("src/test/resource/com/yukms/learn/java/io/File.txt");
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
        URI uri = file.toURI();
        long length = file.length();
        System.out.println(length);
        System.out.println(file.getTotalSpace());
        System.out.println(file.getFreeSpace());
        System.out.println(file.getUsableSpace());
    }
}
