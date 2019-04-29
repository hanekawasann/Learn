package com.yukms.learn.jmockit._06mock;

import com.yukms.learn.jmockit.AnOrdinaryClass;
import mockit.Expectations;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author yukms 763803382@qq.com 2019/4/29 16:32
 */
public class ClassMockingByExpectationsTest {
    @Test
    public void testClassMockingByExpectation() {
        AnOrdinaryClass instanceToRecord = new AnOrdinaryClass();
        new Expectations(AnOrdinaryClass.class) {
            {
                AnOrdinaryClass.staticMethod();
                result = 10;
                instanceToRecord.ordinaryMethod();
                result = 20;
                instanceToRecord.finalMethod();
                result = 30;
                // native, private方法无法用Expectations来Mock
            }
        };
        AnOrdinaryClass instance = new AnOrdinaryClass();
        Assert.assertEquals(10, AnOrdinaryClass.staticMethod());
        Assert.assertEquals(20, instance.ordinaryMethod());
        Assert.assertEquals(30, instance.finalMethod());
        //Assert.assertEquals(4, instance.navtiveMethod());
        Assert.assertEquals(5, instance.callPrivateMethod());
    }

    @BeforeClass
    // 加载AnOrdinaryClass类的native方法的native实现
    public static void loadNative() throws Throwable {
        //JNITools.loadNative();
    }
}
