package com.yukms.learn.java.io;

import java.io.ObjectStreamClass;
import java.io.Serializable;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/10/28 15:13
 */
public class ObjectStreamClassTest implements Serializable {
    @Test
    public void test_lookup() {
        ObjectStreamClass streamClass = ObjectStreamClass.lookup(ObjectStreamClassTest.class);
        Assert.assertNotNull(streamClass);
    }
}
