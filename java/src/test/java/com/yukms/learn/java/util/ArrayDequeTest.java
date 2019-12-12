package com.yukms.learn.java.util;

import java.util.ArrayDeque;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/12/12 17:31
 */
public class ArrayDequeTest {
    @Test
    public void test_new() {
        ArrayDeque<String> strings = new ArrayDeque<>();
    }

    @Test
    public void test_clear() {
        int mask = 10;
        int n = 0;
        for (int i = 0; i < 10; i++) {
            n = (n + 1) & mask;
            System.out.println(n);
        }
    }
}
