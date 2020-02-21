package com.yukms.learn.java.array;

import lombok.AllArgsConstructor;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/9/26 14:12
 */
public class ArrayTest {
    @Test
    public void test_class() {
        String[] stringArray1 = {};
        Class<?> clazz = stringArray1.getClass();
        Assert.assertSame(clazz, String[].class);
        Assert.assertNotSame(clazz, Integer[].class);
    }

    public void test_maxLength() {
        String[] str1 = new String[Integer.MAX_VALUE - 1];
    }
}
