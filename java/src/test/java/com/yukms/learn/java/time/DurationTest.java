package com.yukms.learn.java.time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2020/2/25 9:56
 */
public class DurationTest {
    @Test
    public void test_() {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration.get(ChronoUnit.SECONDS));
    }
}
