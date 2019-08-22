package com.yukms.learn.jvm._08;

/**
 * 单分派与多分派
 *
 * @author hudingpeng hudingpeng@souche.com 2019/8/22 15:38
 */
public class Dispatch {
    static class QQ {}
    static class _360 {}

    public static class Father {
        public void hardChoice(QQ arg) {
            System.out.println("father choose qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("father choose 360");
        }
    }

    public static class Son extends Father {
        @Override
        public void hardChoice(QQ arg) {
            System.out.println("son choose qq");
        }

        @Override
        public void hardChoice(_360 arg) {
            System.out.println("son choose 360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        father.hardChoice(new _360());// father choose 360
        Father son = new Son();
        son.hardChoice(new QQ());// son choose qq
    }
}
