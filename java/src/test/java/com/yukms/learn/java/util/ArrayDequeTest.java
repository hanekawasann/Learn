package com.yukms.learn.java.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/12/12 17:31
 */
public class ArrayDequeTest {
    @Test
    public void test_mask() {
        int length = 8;
        Assert.assertEquals(2, 2 & (length - 1));
        Assert.assertEquals(7, -1 & (length - 1));
    }

    @Test
    public void test_allocateElements() {
        // yukms note: 2的幂次方
        Assert.assertEquals(16, allocateElements(8));
        Assert.assertEquals(16, allocateElements(15));
        Assert.assertEquals(32, allocateElements(16));
    }

    private static int allocateElements(int numElements) {
        int initialCapacity = 8;
        if (numElements >= initialCapacity) {
            initialCapacity = numElements;
            initialCapacity |= (initialCapacity >>> 1);
            initialCapacity |= (initialCapacity >>> 2);
            initialCapacity |= (initialCapacity >>> 4);
            initialCapacity |= (initialCapacity >>> 8);
            initialCapacity |= (initialCapacity >>> 16);
            initialCapacity++;

            if (initialCapacity < 0) {
                initialCapacity >>>= 1;
            }
        }
        return initialCapacity;
    }

    @Test
    public void test_nextTail() {
        Assert.assertEquals(1, nextTail(0, 8));
        Assert.assertEquals(2, nextTail(1, 8));
        Assert.assertEquals(3, nextTail(2, 8));
        Assert.assertEquals(4, nextTail(3, 8));
        Assert.assertEquals(5, nextTail(4, 8));
        Assert.assertEquals(6, nextTail(5, 8));
        Assert.assertEquals(7, nextTail(6, 8));
        Assert.assertEquals(0, nextTail(7, 8));
    }

    private static int nextTail(int tail, int length) {
        return (tail + 1) & (length - 1);
    }

    @Test
    public void test_doubleCapacity() {
        Assert.assertEquals(2, doubleCapacity(1));
        Assert.assertEquals(4, doubleCapacity(2));
        Assert.assertEquals(6, doubleCapacity(3));
        Assert.assertEquals(8, doubleCapacity(4));
    }

    private static int doubleCapacity(int capacity) {
        return capacity << 1;
    }
}
