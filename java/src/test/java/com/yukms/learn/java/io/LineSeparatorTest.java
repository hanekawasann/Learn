package com.yukms.learn.java.io;

import java.security.AccessController;

import org.junit.Assert;
import org.junit.Test;
import sun.security.action.GetPropertyAction;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/11/21 14:11
 */
public class LineSeparatorTest {
    @Test
    public void test_001() {
        String lineSeparator = AccessController.doPrivileged(new GetPropertyAction("line.separator"));
        Assert.assertEquals(lineSeparator, "\r\n");
    }
}
