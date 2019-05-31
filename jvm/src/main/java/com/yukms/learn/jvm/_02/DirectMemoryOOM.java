package com.yukms.learn.jvm._02;

import java.lang.reflect.Field;

import static com.yukms.learn.jvm.JvmConstants._1MB;
import com.yukms.learn.jvm.JvmConstants;
import sun.misc.Unsafe;

/**
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 * <p>
 * Exception in thread "main" java.lang.OutOfMemoryError
 * at sun.misc.Unsafe.allocateMemory(Native Method)
 * at com.yukms.learn.jvm._02.DirectMemoryOOM.main(DirectMemoryOOM.java:21)
 *
 * @author yukms 763803382@qq.com 2019/5/12.
 */
public class DirectMemoryOOM {

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
