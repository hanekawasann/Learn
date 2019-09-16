package com.yukms.learn.java.lang;

import java.lang.reflect.Field;
import java.util.Map;
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

    @Test
    public void test_parallelLockMap() throws NoSuchFieldException, IllegalAccessException {
        Field field = ClassLoader.class.getDeclaredField("parallelLockMap");
        field.setAccessible(true);
        Map map = (Map) field.get(this.getClass().getClassLoader());
        map.forEach((key, value) -> System.out.println(value + "\t\t" + key));
    }

    @Test
    public void test_packages() throws NoSuchFieldException, IllegalAccessException {
        Field field = ClassLoader.class.getDeclaredField("packages");
        field.setAccessible(true);
        Map map = (Map) field.get(this.getClass().getClassLoader());
        map.forEach((key, value) -> System.out.println(key));
    }
}
