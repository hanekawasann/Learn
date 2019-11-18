package com.yukms.learn.java.util.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/11/18 13:55
 */
public class StreamTest {
    @Test
    public void test_01() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add(null);
        System.out.println(list);
        System.out.println(list.stream().filter(Objects::nonNull).collect(Collectors.toList()));
        System.out.println(list);
        list.removeIf(Objects::isNull);
        System.out.println(list);
    }
}
