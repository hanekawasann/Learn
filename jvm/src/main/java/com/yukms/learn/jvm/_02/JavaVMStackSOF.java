package com.yukms.learn.jvm._02;

/**
 * VM Args: -Xss128k
 * <p>
 * stack length:1000
 * Exception in thread "main" java.lang.StackOverflowError
 * at com.yukms.learn.jvm._02.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:12)
 * at com.yukms.learn.jvm._02.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:13)
 * at com.yukms.learn.jvm._02.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:13)
 * at com.yukms.learn.jvm._02.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:13)
 * at com.yukms.learn.jvm._02.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:13)
 * at com.yukms.learn.jvm._02.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:13)
 * at com.yukms.learn.jvm._02.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:13)
 * at com.yukms.learn.jvm._02.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:13)
 * at com.yukms.learn.jvm._02.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:13)
 * ....
 * at com.yukms.learn.jvm._02.JavaVMStackSOF.main(JavaVMStackSOF.java:19)
 *
 * @author yukms 763803382@qq.com 2019/5/6 18:31
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
