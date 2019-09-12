package com.yukms.learn.java.number;

import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/9/12 16:45
 */
public class IntegerTest {
    @Test
    public void test_getInteger() {
        Integer integer = Integer.getInteger("java.lang.Integer.IntegerCache.high");
        System.out.println(integer);
    }
}
