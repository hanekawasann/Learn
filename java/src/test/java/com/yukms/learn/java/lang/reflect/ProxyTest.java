package com.yukms.learn.java.lang.reflect;

import java.lang.reflect.Proxy;

import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/10/10 17:43
 */
public class ProxyTest {
    private interface Eatable { }

    private interface Speakable { }

    private interface Runnable {
        void run();
    }

    @Data
    private static class People implements Runnable {
        public void run() {
            System.out.println("run");
        }
    }

    @Test
    public void test_newProxyInstance() {
        People people = new People();
        ClassLoader classLoader = people.getClass().getClassLoader();
        Class[] classes = { Runnable.class };
        Object target = Proxy.newProxyInstance(classLoader, classes, (proxy, method, args) -> {
            System.out.println("proxy");
            return method.invoke(people, args);
        });
        ((Runnable) target).run();
    }

    @Test
    public void test_getProxyClass_01() {
        ClassLoader classLoader = People.class.getClassLoader();
        Class classes = Runnable.class;
        Assert.assertTrue(Proxy.isProxyClass(Proxy.getProxyClass(classLoader, classes)));
        Assert.assertEquals(Proxy.getProxyClass(classLoader, classes), Proxy.getProxyClass(classLoader, classes));
    }

    @Test
    public void test_getProxyClass_02() {
        ClassLoader classLoader = People.class.getClassLoader();
        Class<?> proxyClass = Proxy.getProxyClass(classLoader, Eatable.class);
        Class<?> proxyClass1 = Proxy.getProxyClass(classLoader, Runnable.class);
        Class<?> proxyClass2 = Proxy.getProxyClass(classLoader, Speakable.class);
        String simpleName = proxyClass.getSimpleName();
        String simpleName1 = proxyClass1.getSimpleName();
        String simpleName2 = proxyClass2.getSimpleName();
        int index = Integer.parseInt(simpleName.substring(simpleName.length() - 1));
        Assert.assertEquals(++index, Integer.parseInt(simpleName1.substring(simpleName1.length() - 1)));
        Assert.assertEquals(++index, Integer.parseInt(simpleName2.substring(simpleName2.length() - 1)));
        Assert.assertTrue(
            proxyClass.getName().startsWith(String.join(".", Eatable.class.getPackage().getName(), "$Proxy")));
    }
}