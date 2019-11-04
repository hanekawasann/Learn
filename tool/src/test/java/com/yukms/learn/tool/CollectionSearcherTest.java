package com.yukms.learn.tool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import com.yukms.learn.utils.Timer;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/11/4 13:56
 */
public class CollectionSearcherTest {
    @Data
    @AllArgsConstructor
    private static class People {
        private String no;
    }

    private static List<People> create(int num) {
        List<People> peoples = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            peoples.add(new People(String.valueOf(i)));
        }
        Collections.shuffle(peoples);
        return peoples;
    }

    @Test
    public void test_searcher() {
        compare(10);
        compare(100);
        compare(1000);
        compare(10000);
    }

    private void compare(Integer no) {
        List<People> peoples = create(no);
        list(no, peoples).printlnCompare(searcher(no, peoples));
    }

    private Timer list(Integer no, List<People> peoples) {
        Timer timer = Timer.start("list");
        for (int i = 0; i < no; i++) {
            People people = getNullIf(String.valueOf(i), peoples, People::getNo);
            Assert.assertNotNull(people);
        }
        timer.end();
        return timer;
    }

    public Timer searcher(Integer no, List<People> peoples) {
        Timer timer = Timer.start("searcher");
        CollectionSearcher<String, People> searcher = CollectionSearcher.newInstance(peoples, People::getNo);
        for (int i = 0; i < no; i++) {
            People people = searcher.get(String.valueOf(i));
            Assert.assertNotNull(people);
        }
        timer.end();
        return timer;
    }

    private static <T, R> R getNullIf(T t, Collection<R> collection, Function<? super R, T> function) {
        for (R r : collection) {
            T rm = function.apply(r);
            if (t.equals(rm)) {
                return r;
            }
        }
        return null;
    }
}