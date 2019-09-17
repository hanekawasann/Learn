package com.yukms.learn.java.lang;

import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/9/17 11:22
 */
public class StringTest {
    @Test
    public void test_equals() {
        new String("abc").equals(new String("abc"));
    }

    @Test
    public void test_note() {
        System.out.println(-1 >>> 1);
    }

    @Test
    public void test_indexOf() {
        new String("123").indexOf("345");
    }
}
