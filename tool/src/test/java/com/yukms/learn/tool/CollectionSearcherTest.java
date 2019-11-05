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
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            integers.add(i);
        }
        List<People> peoples = new ArrayList<>();
        Collections.shuffle(integers);
        for (Integer integer : integers) {
            peoples.add(new People(integer.toString()));
        }
        return peoples;
    }

    @Test
    public void test_searcher() {
        searcherCompareFastSearcher(10);
        searcherCompareFastSearcher(100);
        searcherCompareFastSearcher(1000);
        searcherCompareFastSearcher(10000);
        searcherCompareFastSearcher(100000);
    }

    private void listCompareSearcher(Integer no) {
        List<People> peoples = create(no);
        list(no, peoples).printlnCompare(searcher(no, peoples));
    }

    private void listCompareFastSearcher(Integer no) {
        List<People> peoples = create(no);
        list(no, peoples).printlnCompare(fastSearcher(no, peoples));
    }

    private void searcherCompareFastSearcher(Integer no) {
        List<People> peoples = create(no);
        searcher(no, peoples).printlnCompare(fastSearcher(no, peoples));
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

    public Timer fastSearcher(Integer no, List<People> peoples) {
        Timer timer = Timer.start("fastSearcher");
        FastCollectionSearcher<String, People> searcher = FastCollectionSearcher.newInstance(peoples, People::getNo);
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