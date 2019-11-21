package com.yukms.learn.java.io;

import java.io.BufferedWriter;
import java.io.CharArrayWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/11/21 14:38
 */
public class BufferedWriterTest {
    @Test
    public void test_001() throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(charArrayWriter, 1);
        String s = "123";
        bufferedWriter.write(s, 0, s.length());
        System.out.println(new String(charArrayWriter.toCharArray()));
    }
}
