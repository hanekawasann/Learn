package com.yukms.learn.jvm._03;

import static com.yukms.learn.jvm.JvmConstants._1MB;
import com.yukms.learn.jvm.JvmConstants;

/**
 * Vm Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 *
 * @author yukms 763803382@qq.com 2019/5/31 16:51
 */
public class TestTenuringThreshold2 {
    public static void main(String[] args) {
        byte[] allocation1 = new byte[_1MB / 4];
        byte[] allocation2 = new byte[_1MB / 4];
        byte[] allocation3 = new byte[4 * _1MB];
        byte[] allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }
}
