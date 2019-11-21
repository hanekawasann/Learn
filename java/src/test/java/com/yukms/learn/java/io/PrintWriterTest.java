package com.yukms.learn.java.io;

import java.io.PrintWriter;

import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/11/21 10:46
 */
public class PrintWriterTest {
    @Test
    public void test_print() {
        PrintWriter writer = new PrintWriter(System.out);
        writer.print("1");
        writer.println();
        writer.print("2");
        writer.flush();
    }
}
