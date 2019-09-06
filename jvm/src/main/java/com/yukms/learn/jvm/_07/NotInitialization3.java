package com.yukms.learn.jvm._07;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/9/6 17:12
 */
public class NotInitialization3 {
    public static void main(String[] args) {
        String string = ConstClass.STRING;
        byte aByte = ConstClass.BYTE;
        int anInt = ConstClass.INT;
        long aLong = ConstClass.LONG;
        double aDouble = ConstClass.DOUBLE;
        float aFloat = ConstClass.FLOAT;
        boolean aBoolean = ConstClass.BOOLEAN;
        // ConstClass init!
        // SuperClass superClass = ConstClass.SUPER_CLASS;
    }
}
