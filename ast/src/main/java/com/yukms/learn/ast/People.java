package com.yukms.learn.ast;

/**
 * @author hudingpeng hudingpeng@souche.com 2020/3/10 17:52
 */
public class People {
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public People setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public People setAge(int age) {
        this.age = age;
        return this;
    }
}
