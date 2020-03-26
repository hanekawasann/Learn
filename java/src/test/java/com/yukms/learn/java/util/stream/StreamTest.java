package com.yukms.learn.java.util.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/11/18 13:55
 */
public class StreamTest {

    @AllArgsConstructor
    @Data
    private static class People {
        private String name;
    }

    @Test(expected = IllegalStateException.class)
    public void test_toMap() {
        List<People> list = new ArrayList<>();
        list.add(new People("1"));
        list.add(new People("1"));
        list.stream().collect(Collectors.toMap(People::getName, Function.identity()));
    }

    @Test
    public void test_filter() {
        List<People> list = new ArrayList<>();
        People people = new People("1");
        list.add(people);
        List<People> collect = list.stream().filter(v -> {
            v.setName("2");
            return true;
        }).collect(Collectors.toList());
        Assert.assertEquals("2", people.getName());
        Assert.assertEquals("2", collect.get(0).getName());
    }

    @Test
    public void test_empty() {
        Assert.assertTrue(new ArrayList<>().stream().allMatch(o -> false));
        Assert.assertTrue(new ArrayList<>().stream().allMatch(o -> true));
    }
}
