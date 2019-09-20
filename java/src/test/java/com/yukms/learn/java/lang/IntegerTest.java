package com.yukms.learn.java.lang;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/9/19 11:46
 */
public class IntegerTest {
    @Test
    public void test_toString_1() {
        new Integer("123").toString();
    }

    @Test
    public void test_toString_2() {
        Assert.assertEquals("2147483647", Integer.toString(Integer.MAX_VALUE));
    }

    @Test
    public void test_toXxxString() {
        // 二进制
        Assert.assertEquals("1111011", Integer.toBinaryString(123));
        // 八进制
        Assert.assertEquals("173", Integer.toOctalString(123));
        // 十六进制
        Assert.assertEquals("7b", Integer.toHexString(123));
    }

    @Test
    public void test_stringSize() {
        Assert.assertEquals(1, stringSize(1));
        Assert.assertEquals(2, stringSize(11));
        Assert.assertEquals(3, stringSize(111));
        Assert.assertEquals(4, stringSize(1111));
        Assert.assertEquals(5, stringSize(11111));
        Assert.assertEquals(6, stringSize(111111));
        Assert.assertEquals(7, stringSize(1111111));
        Assert.assertEquals(8, stringSize(11111111));
        Assert.assertEquals(9, stringSize(111111111));
    }

    private static final int MAX_LENGTH = 10;

    private static int stringSize(int x) {
        int p = 10;
        for (int i = 1; i < MAX_LENGTH; i++) {
            if (x < p) {
                return i;
            }
            p *= 10;
        }
        return MAX_LENGTH;
    }
}
