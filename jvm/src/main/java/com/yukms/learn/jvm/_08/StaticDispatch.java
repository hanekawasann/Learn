package com.yukms.learn.jvm._08;

/**
 * 静态分派
 *
 * @author hudingpeng hudingpeng@souche.com 2019/8/22 14:58
 */
public class StaticDispatch {
    static abstract class Human { }

    static class Man extends Human { }

    static class woman extends Human { }

    public void sayHello(Human human) {
        System.out.println("hello, guy!");
    }

    public void sayHello(Man man) {
        System.out.println("hello, man!");
    }

    public void sayHello(woman woman) {
        System.out.println("hello, woman!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new woman();
        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.sayHello(man);// hello, guy!
        staticDispatch.sayHello(woman);// hello, guy!
    }
}
