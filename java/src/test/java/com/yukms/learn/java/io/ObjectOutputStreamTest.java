package com.yukms.learn.java.io;

import java.io.IOException;
import java.io.ObjectOutputStream;

import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/10/24 17:31
 */
public class ObjectOutputStreamTest {
    @Test
    public void test_new() throws IOException {
        ObjectOutputStream stream = new ObjectOutputStream(null);
    }
}
