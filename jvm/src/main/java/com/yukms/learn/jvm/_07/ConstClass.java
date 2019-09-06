package com.yukms.learn.jvm._07;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/9/6 17:12
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }

    public static final String STRING = "hello world";
    public static final byte BYTE = 1;
    public static final int INT = 1;
    public static final long LONG = 1;
    public static final double DOUBLE = 1;
    public static final float FLOAT = 1;
    public static final boolean BOOLEAN = true;
    public static final SuperClass SUPER_CLASS = new SuperClass();
}
