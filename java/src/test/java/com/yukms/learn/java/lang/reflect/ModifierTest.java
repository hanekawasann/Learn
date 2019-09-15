package com.yukms.learn.java.lang.reflect;

import java.lang.reflect.Modifier;

import org.junit.Assert;
import org.junit.Test;

public class ModifierTest {
    @Test
    public void test_isPublic() {
        Assert.assertTrue(Modifier.isPublic(1));
        Assert.assertFalse(Modifier.isPublic(10));
        Assert.assertTrue(Modifier.isPublic(11));
    }
}
