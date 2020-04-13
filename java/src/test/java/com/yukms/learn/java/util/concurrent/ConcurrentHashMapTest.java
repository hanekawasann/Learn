package com.yukms.learn.java.util.concurrent;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2020/4/13 13:59
 */
public class ConcurrentHashMapTest {
    @Test
    public void test_ConcurrentHashMap() {
        // yukms note: 1/2
        Assert.assertEquals(0, 1 >>> 1);
        Assert.assertEquals(1, 2 >>> 1);
        Assert.assertEquals(1, 3 >>> 1);
        Assert.assertEquals(2, 4 >>> 1);
    }
}
