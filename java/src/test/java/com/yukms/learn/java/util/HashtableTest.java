package com.yukms.learn.java.util;

import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;

import lombok.AllArgsConstructor;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2020/2/20 16:39
 */
public class HashtableTest {
    @Test
    public void test_01() {
        Map<People, String> map = new Hashtable<>();
        People people1 = new People("1");
        People people2 = new People("2");
        map.put(people1, "1");
        map.put(people2, "2");
        Assert.assertEquals("1", map.get(people1));
        Assert.assertEquals("2", map.get(people2));
    }

    @AllArgsConstructor
    public static final class People {
        private String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) { return true; }
            if (o == null || getClass() != o.getClass()) { return false; }
            People people = (People) o;
            return Objects.equals(name, people.name);
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }
}
