package com.yukms.learn.java.array;

import java.util.Arrays;
import java.util.List;

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

    @Test
    public void test_asList() {
        String[] strings = new String[2];
        List<String> list = Arrays.asList(strings);
        Assert.assertEquals(null, list.get(0));
        Assert.assertEquals(null, list.get(1));
    }

    @Test
    public void test_copyOf() {
        Assert.assertArrayEquals(new String[] {}, Arrays.copyOf(new String[] {}, 0, String[].class));
        Assert.assertArrayEquals(new String[1], Arrays.copyOf(new String[2], 1, String[].class));
    }
}
