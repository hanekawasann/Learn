package com.yukms.learn.java.lang.reflect;

import java.lang.reflect.Proxy;

import lombok.Data;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/10/10 17:43
 */
public class ProxyTest {
    private interface Runnable {
        void run();
    }

    @Data
    private static class People implements Runnable {
        public void run() { }
    }

    @Test
    public void test_newProxyInstance() {
        People people = new People();
        Object target = Proxy.newProxyInstance(people.getClass().getClassLoader(), new Class[] { Runnable.class },
            (proxy, method, args) -> {
                System.out.println("proxy");
                return null;
            });
        ((Runnable) target).run();
    }
}
