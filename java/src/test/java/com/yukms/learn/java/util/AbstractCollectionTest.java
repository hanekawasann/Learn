package com.yukms.learn.java.util;

import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/11/25 15:49
 */
public class AbstractCollectionTest {
    @Test
    public void test_001() {
        for (int cap = 0; cap < 10; cap++) {
            int newCap = cap + (cap >> 1) + 1;
            System.out.println(newCap);
        }
    }
}
