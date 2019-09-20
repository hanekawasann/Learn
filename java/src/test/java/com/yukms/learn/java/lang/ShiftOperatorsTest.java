package com.yukms.learn.java.lang;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/9/19 14:27
 */
public class ShiftOperatorsTest {
    /**
     * 左移<<
     * 乘以2的几次方
     */
    @Test
    public void test_left() {
        Assert.assertEquals(1 * Math.pow(2, 3), 1 << 3, 0.0);
    }

    /**
     * 右移>>
     */
    @Test
    public void test_right() {
        Assert.assertEquals(10 ,20 >> 1);
        Assert.assertEquals(5 ,10 >> 1);
        Assert.assertEquals(4 ,8 >> 1);
        Assert.assertEquals(3 ,6 >> 1);
        Assert.assertEquals(1 ,2 >> 1);
        Assert.assertEquals(0 ,1 >> 1);
        Assert.assertEquals(0 ,0 >> 1);
    }

    /**
     * 无符号右移>>>
     * 除以2的几次方
     */
    @Test
    public void test_unsigned_right() {
        int dividend = (int) Math.pow(2, 3);
        Assert.assertEquals( dividend / Math.pow(2, 3), dividend >>> 3, 0.0);
    }
}
