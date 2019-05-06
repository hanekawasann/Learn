package com.yukms.learn.jvm._01;

/**
 * VM Args: -Xss2M
 *
 * @author yukms 763803382@qq.com 2019/5/6 18:52
 */
public class JavaVMStackOOM {
    private void dontStop() {
        while (true) {}
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
