package com.yukms.learn.java.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/12/23 17:18
 */
public class PriorityQueueTest {
    @Test
    public void test_heapify() {
        Assert.assertEquals(4, 8 >>> 1);
        Assert.assertEquals(4, 9 >>> 1);
        Assert.assertEquals(5, 10 >>> 1);
    }

    @Test
    public void test_siftDown() {
        Assert
            .assertArrayEquals(new Comparable[] { 1, 2, 3, 5, 4, 6 }, siftDown(new Comparable[] { 6, 2, 3, 5, 4, 1 }));
    }

    @SuppressWarnings("unchecked")
    private static Comparable[] siftDown(Comparable[] array) {
        int size = array.length;
        int half = size >>> 1;
        for (int i = half - 1; i >= 0; i--) {
            Comparable key = array[i];
            while (i < half) {
                int child = (i << 1) + 1;
                Comparable c = array[child];
                int right = child + 1;
                if (right < size && c.compareTo(array[right]) > 0) {
                    c = array[child = right];
                }
                if (key.compareTo(c) <= 0) {
                    break;
                }
                array[i] = c;
                i = child;
            }
            array[i] = key;
        }
        return array;
    }
}
