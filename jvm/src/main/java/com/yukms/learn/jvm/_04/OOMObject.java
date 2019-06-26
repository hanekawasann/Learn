package com.yukms.learn.jvm._04;

import java.util.ArrayList;
import java.util.List;

import com.yukms.learn.jvm.JvmConstants;

/**
 * Vm Args: -Xms100m -Xmx100m -XX:+UseSerialGC
 *
 * @author yukms 763803382@qq.com 2019/6/26 14:17
 */
public class OOMObject {
    public byte[] placeholder = new byte[JvmConstants._1MB];

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(500);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
