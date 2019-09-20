package com.yukms.learn.java.lang;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/9/18 11:32
 */
public class AbstractStringBuilderTest {
    @Test
    public void test_setLength() {
        StringBuilder builder = new StringBuilder("123");
        // 扩容
        builder.setLength(100);
        // 填充
        System.out.println("---");
        System.out.println('\u0000' == '\0');
        System.out.println("---");
    }

    @Test
    public void test_append_int() {
        StringBuilder builder = new StringBuilder();
        builder.append("String ");
        builder.append(1);
        Assert.assertEquals("String 1", builder.toString());
    }
}
