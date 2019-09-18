package com.yukms.learn.java.lang;

import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/9/18 11:32
 */
public class AbstractStringBuilderTest {
    @Test
    public void test_setLength() {
        StringBuilder builder = new StringBuilder("123");
        builder.setLength(100);
        System.out.println("---");
        System.out.println('\u0000' == '\0');
        System.out.println("---");
    }
}
