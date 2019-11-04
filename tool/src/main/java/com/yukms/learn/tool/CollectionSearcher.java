package com.yukms.learn.tool;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.function.Function;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/11/4 11:47
 */
public final class CollectionSearcher<T, R> {
    private TreeMap<T, R> map;

    private CollectionSearcher(TreeMap<T, R> map) {
        this.map = map;
    }

    public R get(T t) {
        return map.get(t);
    }

    public static <T, R> CollectionSearcher<T, R> newInstance(Collection<R> collection,
        Function<? super R, T> function) {
        TreeMap<T, R> map = new TreeMap<>();
        for (R r : collection) {
            map.put(function.apply(r), r);
        }
        return new CollectionSearcher<>(map);
    }

    public static <T, R> CollectionSearcher<T, R> newInstance(Collection<R> collection, Function<? super R, T> function,
        Comparator<? super T> comparator) {
        TreeMap<T, R> map = new TreeMap<>(comparator);
        for (R r : collection) {
            map.put(function.apply(r), r);
        }
        return new CollectionSearcher<>(map);
    }
}
