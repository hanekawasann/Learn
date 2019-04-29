package com.yukms.learn.jmockit;

/**
 * @author yukms 763803382@qq.com 2019/4/29 17:55
 */
public class AnOrdinaryClassWithBlock {
    public static int j;
    private int i;

    {
        i = 1;
    }

    static {
        j = 2;
    }

    public AnOrdinaryClassWithBlock(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
