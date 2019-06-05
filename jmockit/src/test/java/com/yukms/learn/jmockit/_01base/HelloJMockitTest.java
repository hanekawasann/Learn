package com.yukms.learn.jmockit._01base;

import java.util.Locale;

import com.yukms.learn.jmockit.HelloJMockit;
import mockit.Expectations;
import mockit.Verifications;
import mockit.VerificationsInOrder;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yukms 763803382@qq.com 2019/4/29 11:32
 */
public class HelloJMockitTest {
    @Test
    public void testSayHelloAtChina() {
        new Expectations(Locale.class) {
            {
                Locale.getDefault();
                result = Locale.CHINA;
            }
        };
        Assert.assertEquals("你好，JMockit!", (new HelloJMockit()).sayHello());
        new Verifications() {
            {
                Locale.getDefault();
                // 为什么是两次
                times = 2;
            }
        };
    }

    @Test
    public void testSayHelloAtUS() {
        new Expectations(Locale.class) {
            {
                Locale.getDefault();
                result = Locale.US;
            }
        };
        Assert.assertEquals("Hello，JMockit!", (new HelloJMockit()).sayHello());
    }
}
