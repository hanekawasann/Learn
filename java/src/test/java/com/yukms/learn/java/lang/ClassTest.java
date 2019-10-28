package com.yukms.learn.java.lang;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class ClassTest {
    @Test
    public void test_toGenericString() {
        Assert.assertEquals("public class java.util.ArrayList<E>", ArrayList.class.toGenericString());
    }

    public static Class clazz;

    private static class People {
        public People() {
            clazz = getClass();
        }
    }

    private static class Student extends People { }

    @Test
    public void test_subclass() {
        new People();
        Assert.assertEquals(People.class, clazz);
        new Student();
        Assert.assertEquals(Student.class, clazz);
    }
}