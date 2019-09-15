package com.yukms.learn.java.lang;

import java.lang.reflect.Field;
import java.util.Vector;

import org.junit.Test;

public class ClassLoaderTest {
    @Test
    public void test_classes() throws NoSuchFieldException, IllegalAccessException {
        Field field = ClassLoader.class.getDeclaredField("classes");
        field.setAccessible(true);
        Vector<?> classes = (Vector<?>) field.get(this.getClass().getClassLoader());
        classes.forEach(System.out::println);
    }
}
