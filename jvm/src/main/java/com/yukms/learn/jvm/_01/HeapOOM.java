package com.yukms.learn.jvm._01;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * <p>
 * <code>
 * java.lang.OutOfMemoryError: Java heap space
 * Dumping heap to java_pid14160.hprof ...
 * Heap dump file created [28287368 bytes in 0.154 secs]
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 * at java.util.Arrays.copyOf(Arrays.java:3210)
 * at java.util.Arrays.copyOf(Arrays.java:3181)
 * at java.util.ArrayList.grow(ArrayList.java:265)
 * at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:239)
 * at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:231)
 * at java.util.ArrayList.add(ArrayList.java:462)
 * at com.yukms.learn.jvm._01.HeapOOM.main(HeapOOM.java:18)
 * </code>
 *
 * @author yukms 763803382@qq.com 2019/5/6 17:51
 */
public class HeapOOM {

    private static class OOMObject { }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

}
