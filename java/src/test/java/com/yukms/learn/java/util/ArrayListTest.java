package com.yukms.learn.java.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/12/2 11:33
 */
public class ArrayListTest {
    @Test
    public void test_capacity() {
        ArrayList<Object> list = new ArrayList<>();
        //list.ensureCapacity(Integer.MAX_VALUE - 8);
    }

    @Test
    public void test_toArray() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer[] integers = { 1, 2, 3, 4, 5 };
        integers = list.toArray(integers);
        Assert.assertEquals(1, integers[0].intValue());
        Assert.assertEquals(2, integers[1].intValue());
        Assert.assertEquals(3, integers[2].intValue());
        // 注意
        Assert.assertNull(integers[3]);
        Assert.assertEquals(5, integers[4].intValue());
    }

    @Test
    public void test_clone() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        ArrayList<Integer> clone = (ArrayList<Integer>) list.clone();
        Assert.assertEquals(1, clone.get(0).intValue());
        Assert.assertEquals(1, clone.size());
    }
}
