package com.yukms.learn.java.time;

import java.time.LocalDate;

import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/10/14 14:47
 */
public class LocalDateTest {
    @Test
    public void test_01() {
        LocalDate start = LocalDate.of(2019, 9, 6);
        LocalDate moved = LocalDate.of(2019, 9, 20);
        LocalDate end = LocalDate.of(2019, 10, 13);
        long dayNum = end.getDayOfYear() - start.getDayOfYear();
        long dayNum1 = moved.getDayOfYear() - start.getDayOfYear();
        long dayNum2 = end.getDayOfYear() - moved.getDayOfYear();
        double people1 = (dayNum1 / 2.0 + dayNum2 / 3.0) / dayNum * 303.38;
        double people2 = (dayNum2 / 3.0) / dayNum * 303.38;
        System.out.println(people1);
        System.out.println(people2);
        System.out.println(people1 * 2 + people2);
    }
}
