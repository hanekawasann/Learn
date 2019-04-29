package com.yukms.learn.jmockit._07advanced;

import com.yukms.learn.jmockit.ISayHello;
import com.yukms.learn.jmockit.SayHello;
import mockit.Delegate;
import mockit.Expectations;
import mockit.Invocation;
import org.junit.Test;
import org.springframework.util.Assert;

/**
 * @author yukms 763803382@qq.com 2019/4/29 18:37
 */
public class DeletgateResultTest {
    @SuppressWarnings("rawtypes")
    @Test
    public void testDelegate() {
        SayHello instance = new SayHello();
        new Expectations(SayHello.class) {
            {
                instance.sayHello(anyString, anyInt);
                result = new Delegate() {
                    // 当调用sayHello(anyString, anyInt)时，返回的结果就会匹配delegate方法，
                    // 方法名可以自定义，当入参和返回要与sayHello(anyString, anyInt)匹配上
                    @SuppressWarnings("unused")
                    String delegate(Invocation inv, String who, int gender) {
                        if ("Polly".equals(who)) {
                            return "hello,Polly";
                        }
                        return inv.proceed(who, gender);
                    }
                };

            }
        };

        Assert.isTrue(instance.sayHello("david", ISayHello.MALE).equals("hello Mr david"));
        Assert.isTrue(instance.sayHello("lucy", ISayHello.FEMALE).equals("hello Mrs lucy"));
        Assert.isTrue(instance.sayHello("Polly", ISayHello.FEMALE).equals("hello,Polly"));
    }
}
