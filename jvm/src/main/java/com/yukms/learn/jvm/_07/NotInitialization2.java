package com.yukms.learn.jvm._07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/9/6 17:10
 */
public class NotInitialization2 {
    public static void main(String[] args) {
        SuperClass[] superClasses = new SuperClass[10];
        List<SuperClass> list = new ArrayList<>();
    }
}
