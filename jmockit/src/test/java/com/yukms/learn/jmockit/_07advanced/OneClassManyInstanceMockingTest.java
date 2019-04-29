package com.yukms.learn.jmockit._07advanced;

import com.yukms.learn.jmockit.AnOrdinaryClass;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yukms 763803382@qq.com 2019/4/29 18:07
 */
public class OneClassManyInstanceMockingTest {
    @Test
    public void testMocking1() {
        AnOrdinaryClass instance1 = new AnOrdinaryClass();
        AnOrdinaryClass instance2 = new AnOrdinaryClass();
        new Expectations(instance1, instance2) {
            {
                instance1.ordinaryMethod();
                result = 20;
                instance2.ordinaryMethod();
                result = 200;
            }
        };
        AnOrdinaryClass instance3 = new AnOrdinaryClass();
        Assert.assertEquals(20, instance1.ordinaryMethod());
        Assert.assertEquals(200, instance2.ordinaryMethod());
        Assert.assertEquals(2, instance3.ordinaryMethod());
    }

    @Test
    public void testMocking2(@Mocked AnOrdinaryClass instance1, @Mocked AnOrdinaryClass instance2) {
        new Expectations() {
            {
                instance1.ordinaryMethod();
                result = 20;
                instance2.ordinaryMethod();
                result = 200;
            }
        };
        AnOrdinaryClass instance3 = new AnOrdinaryClass();
        Assert.assertEquals(20, instance1.ordinaryMethod());
        Assert.assertEquals(200, instance2.ordinaryMethod());
        Assert.assertEquals(0, instance3.ordinaryMethod());
    }

    @Test
    public void testMocking3(@Injectable AnOrdinaryClass instance1, @Injectable AnOrdinaryClass instance2) {
        new Expectations() {
            {
                instance1.ordinaryMethod();
                result = 20;
                instance2.ordinaryMethod();
                result = 200;
            }
        };
        AnOrdinaryClass instance3 = new AnOrdinaryClass();
        Assert.assertEquals(20, instance1.ordinaryMethod());
        Assert.assertEquals(200, instance2.ordinaryMethod());
        Assert.assertEquals(2, instance3.ordinaryMethod());
    }
}
