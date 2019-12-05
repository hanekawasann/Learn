package com.yukms.learn.java.util;

import java.util.LinkedList;
import java.util.ListIterator;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/12/5 15:01
 */
public class LinkedListTest {
    @Test
    public void test_listIterator() {
        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        ListIterator<String> iterator = list.listIterator();
        Assert.assertEquals("1", iterator.next());
        Assert.assertEquals("2", iterator.next());
        Assert.assertEquals("2", iterator.previous());
        Assert.assertEquals("1", iterator.previous());
        Assert.assertEquals("1", iterator.next());
    }
}
