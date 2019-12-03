package com.yukms.learn.java.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/12/3 11:14
 */
public class AbstractListTest {
    private static class People { }

    private static class Student extends People { }

    @Test(expected = ArrayStoreException.class)
    public void test_array() {
        Student[] students = new Student[] { new Student() };
        Assert.assertEquals(Student.class, students.getClass().getComponentType());
        People[] people = students;
        Assert.assertEquals(Student.class, people.getClass().getComponentType());
        people[0] = new People();
    }

    @Test(expected = ArrayStoreException.class)
    public void test_asList() {
        List<String> list = Arrays.asList("abc");
        Object[] objects = list.toArray();
        Assert.assertEquals(String.class, objects.getClass().getComponentType());
        objects[0] = new Object();
    }

    @Test
    public void test_arrayList() {
        List<String> list = new ArrayList<>();
        list.add("abc");
        Object[] objects = list.toArray();
        Assert.assertEquals(Object.class, objects.getClass().getComponentType());
        objects[0] = new Object();
    }
}
