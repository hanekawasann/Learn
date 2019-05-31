package com.yukms.learn.jvm._03;

import static com.yukms.learn.jvm.JvmConstants._1MB;
import com.yukms.learn.jvm.JvmConstants;

/**
 * Vm Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 * [GC (Allocation Failure) [PSYoungGen: 8158K->744K(9216K)] 8158K->6896K(19456K), 0.0039634 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [Full GC (Ergonomics) [PSYoungGen: 744K->0K(9216K)] [ParOldGen: 6152K->6754K(10240K)] 6896K->6754K(19456K), [Metaspace: 3125K->3125K(1056768K)], 0.0070093 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 * Heap
 *  PSYoungGen      total 9216K, used 3237K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
 *   eden spa
 *   ce 8192K, 39% used [0x00000000ff600000,0x00000000ff929790,0x00000000ffe00000)
 *   from space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
 *   to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
 *  ParOldGen       total 10240K, used 6754K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
 *   object space 10240K, 65% used [0x00000000fec00000,0x00000000ff298ac8,0x00000000ff600000)
 *  Metaspace       used 3136K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 343K, capacity 388K, committed 512K, reserved 1048576K
 *
 * @author yukms 763803382@qq.com 2019/5/31 14:50
 */
public class TestAllocation {
    public static void main(String[] args) {
        byte[] allocation1 = new byte[2 * _1MB];
        byte[] allocation2 = new byte[2 * _1MB];
        byte[] allocation3 = new byte[2 * _1MB];
        // 出现一次Minor GC
        byte[] allocation4 = new byte[3 * _1MB];
    }
}
