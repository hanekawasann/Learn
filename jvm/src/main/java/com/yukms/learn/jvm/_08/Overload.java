package com.yukms.learn.jvm._08;

import java.io.Serializable;

/**
 * 重载
 *
 * @author hudingpeng hudingpeng@souche.com 2019/8/22 15:15
 */
public class Overload {
    public static void sayHello(Object arg) {
        System.out.println("hello Object");
    }

    public static void sayHello(int arg) {
        System.out.println("hello int");
    }

    public static void sayHello(long arg) {
        System.out.println("hello long");
    }

    public static void sayHello(Character arg) {
        System.out.println("hello Character");
    }

    public static void sayHello(char arg) {
        System.out.println("hello char");
    }

    public static void sayHello(Serializable arg) {
        System.out.println("hello Serializable");
    }

    public static void main(String[] args) {
        // char -> int -> long -> float -> double
        sayHello('a');
    }
}
