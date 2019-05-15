package com.yukms.learn.jvm._02;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * <p>
 * -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 * <p>
 * Caused by: java.lang.OutOfMemoryError: Metaspace
 * at java.lang.ClassLoader.defineClass1(Native Method)
 * at java.lang.ClassLoader.defineClass(ClassLoader.java:763)
 * ... 11 more
 *
 * @author yukms 763803382@qq.com 2019/5/12.
 */
public class JavaMethodAreaOOM {

    public static void main(final String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
                    throws Throwable {
                    return methodProxy.invokeSuper(o, args);
                }
            });
            enhancer.create();
        }
    }

    static class OOMObject {

    }

}
