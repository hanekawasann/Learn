package com.yukms.learn.java;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2020/2/20 15:17
 */
public class OperatorTest {
    @Test
    public void test_and() {
        Assert.assertEquals(0 ,0 & 2);
        Assert.assertEquals(0 ,1 & 2);
        Assert.assertEquals(2 ,2 & 2);
        Assert.assertEquals(0 ,0 & 4);
        Assert.assertEquals(0 ,1 & 4);
        Assert.assertEquals(0 ,2 & 4);
        Assert.assertEquals(0 ,3 & 4);
        Assert.assertEquals(4 ,4 & 4);

        Assert.assertEquals(0 ,2 & 0);
        Assert.assertEquals(0 ,2 & 1);
        Assert.assertEquals(0 ,4 & 0);
        Assert.assertEquals(0 ,4 & 1);
        Assert.assertEquals(0 ,4 & 2);
        Assert.assertEquals(0 ,4 & 3);
    }
}
