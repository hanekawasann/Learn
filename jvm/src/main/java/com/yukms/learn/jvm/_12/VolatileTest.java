package com.yukms.learn.jvm._12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatileTest {
    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    public static final int THREAD_COUNT = 20;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < THREAD_COUNT; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < 10000; j++) {
                    increase();
                }
            });
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.yield();
        }
        System.out.println(race);
    }
}