package com.yukms.learn.java.io;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/11/21 14:00
 */
public class CharArrayWriterTest {
    @Test
    public void test_001() {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        PrintWriter printWriter = new PrintWriter(charArrayWriter);
        printWriter.println("a");
        printWriter.println("b");
        printWriter.println("c");
        char[] chars = charArrayWriter.toCharArray();
        String s = new String(chars);
        System.out.println(s);
    }
}
