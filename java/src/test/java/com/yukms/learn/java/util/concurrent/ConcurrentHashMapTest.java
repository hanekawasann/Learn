package com.yukms.learn.java.util.concurrent;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2020/4/13 13:59
 */
public class ConcurrentHashMapTest {
    @Test
    public void test_ConcurrentHashMap() {
        // yukms note: n/2
        Assert.assertEquals(0, 1 >>> 1);
        Assert.assertEquals(1, 2 >>> 1);
        Assert.assertEquals(1, 3 >>> 1);
        Assert.assertEquals(2, 4 >>> 1);
    }

    @Test
    public void test_tryPresize_sz() {
        Assert.assertEquals(2, tryPresize_sz(2));
        Assert.assertEquals(3, tryPresize_sz(4));
        Assert.assertEquals(6, tryPresize_sz(8));
        Assert.assertEquals(12, tryPresize_sz(16));
    }

    private int tryPresize_sz(int n) {
        // yukms note: n-n/4=(3/4)n
        return n - (n >>> 2);
    }

    @Test
    public void test_tableSizeFor() {
        Assert.assertEquals(2, tableSizeFor(2));
        Assert.assertEquals(4, tableSizeFor(4));
    }

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    private int tableSizeFor(int c) {
        // yukms note: 与JDK8 HashMap一致
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
