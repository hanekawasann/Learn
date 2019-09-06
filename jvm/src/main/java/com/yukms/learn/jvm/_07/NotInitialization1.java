package com.yukms.learn.jvm._07;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/9/6 17:08
 */
public class NotInitialization1 {
    public static void main(String[] args) {
        // SuperClass init!
        int value = SubClass.VALUE;
    }
}
