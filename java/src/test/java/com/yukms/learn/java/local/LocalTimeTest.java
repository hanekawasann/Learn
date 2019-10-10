package com.yukms.learn.java.local;

import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/10/9 15:51
 */
public class LocalTimeTest {
    @Test
    public void test_isBefore() {
        LocalTime time1 = LocalTime.of(1, 1);
        LocalTime time2 = LocalTime.of(1, 2);
        LocalTime time3 = LocalTime.of(1, 1);
        Assert.assertTrue(time1.isBefore(time2));
        Assert.assertTrue(time2.isAfter(time1));
        Assert.assertFalse(time1.isBefore(time3));
        Assert.assertFalse(time1.isAfter(time3));
        Assert.assertTrue(time1.compareTo(time2) < 0);
        Assert.assertTrue(time2.compareTo(time1) > 0);
        Assert.assertEquals(0, time1.compareTo(time3));
    }
}
