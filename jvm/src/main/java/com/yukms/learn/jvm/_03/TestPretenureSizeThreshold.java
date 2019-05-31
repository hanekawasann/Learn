package com.yukms.learn.jvm._03;

import static com.yukms.learn.jvm.JvmConstants._1MB;
import com.yukms.learn.jvm.JvmConstants;

/**
 * Vm Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 *
 * @author yukms 763803382@qq.com 2019/5/31 16:45
 */
public class TestPretenureSizeThreshold {
    public static void main(String[] args) {
        byte[] allocation = new byte[4 * _1MB];
    }
}
