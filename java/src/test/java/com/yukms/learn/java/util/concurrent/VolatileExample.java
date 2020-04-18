package com.yukms.learn.java.util.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author hudingpeng hudingpeng@souche.com 2020/4/18 13:59
 *
 * -Djava.compiler=NONE
 */
public class VolatileExample {
    private static boolean flag = false;
    private static int i = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                flag = true;
                System.out.println("flag 被修改成 true");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        while (!flag) {
            i++;
        }
        System.out.println("程序结束,i=" + i);
    }
}
