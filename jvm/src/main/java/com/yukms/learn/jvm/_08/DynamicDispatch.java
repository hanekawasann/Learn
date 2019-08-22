package com.yukms.learn.jvm._08;

/**
 * 动态分派
 *
 * @author hudingpeng hudingpeng@souche.com 2019/8/22 15:20
 */
public class DynamicDispatch {
    static abstract class Human {
        protected abstract void sayHello();
    }

    static class Man extends Human {

        @Override
        protected void sayHello() {
            System.out.println("man say hello");
        }
    }

    static class Woman extends Human {

        @Override
        protected void sayHello() {
            System.out.println("woman say hello");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();// man say hello
        woman.sayHello();// woman say hello
        man = new Woman();
        man.sayHello();// woman say hello
    }
}
