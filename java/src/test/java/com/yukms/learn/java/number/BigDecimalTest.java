package com.yukms.learn.java.number;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/12/17 17:46
 */
public class BigDecimalTest {
    @Test
    public void test_valueOf() {
        Assert.assertEquals("139.80", new BigDecimal("139.80").toString());
        Assert.assertEquals("139.8", BigDecimal.valueOf(Double.parseDouble("139.80")).toString());
        Assert.assertNotNull("139.80", new BigDecimal(139.80).toString());
    }
}
