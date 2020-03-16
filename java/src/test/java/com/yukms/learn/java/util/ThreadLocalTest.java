package com.yukms.learn.java.util;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2020/3/16 17:44
 */
public class ThreadLocalTest {

    @Test
    public void test_reuse() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.submit(() -> NameCache.set("name"));
        Future<String> future = service.submit(NameCache::get);
        Assert.assertEquals("name", future.get());
    }

    private static class NameCache {
        private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

        public static void set(String name) {
            THREAD_LOCAL.set(name);
        }

        public static String get() {
            return THREAD_LOCAL.get();
        }
    }
}
