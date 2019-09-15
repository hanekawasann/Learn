package com.yukms.learn.java.lang;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class ClassTest {
    @Test
    public void test_toGenericString() {
        Assert.assertEquals("public class java.util.ArrayList<E>", ArrayList.class.toGenericString());
    }
}