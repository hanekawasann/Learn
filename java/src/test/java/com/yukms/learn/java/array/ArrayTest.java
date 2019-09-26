package com.yukms.learn.java.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/9/26 14:12
 */
public class ArrayTest {
    @Test
    public void test_class() {
        String[] stringArray1 = {};
        Assert.assertSame(stringArray1.getClass(), String[].class);
        Assert.assertNotSame(stringArray1.getClass(), Integer[].class);
    }
}
