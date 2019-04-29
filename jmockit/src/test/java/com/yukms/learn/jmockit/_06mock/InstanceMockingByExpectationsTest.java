package com.yukms.learn.jmockit._06mock;

import com.yukms.learn.jmockit.AnOrdinaryClass;
import mockit.Expectations;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author yukms 763803382@qq.com 2019/4/29 16:37
 */
public class InstanceMockingByExpectationsTest {
    @Test
    public void testInstanceMockingByExpectation() {
        AnOrdinaryClass instance = new AnOrdinaryClass();
        // 只影响一个实例
        new Expectations(instance) {
            {
                // 尽管这里也可以Mock静态方法，但不推荐在这里写。静态方法的Mock应该是针对类的
                instance.ordinaryMethod();
                result = 20;
                instance.finalMethod();
                result = 30;
                // native, private方法无法用Expectations来Mock
            }
        };
        Assert.assertEquals(1, AnOrdinaryClass.staticMethod());
        Assert.assertEquals(20, instance.ordinaryMethod());
        Assert.assertEquals(30, instance.finalMethod());
        // 用Expectations无法mock native方法
        //Assert.assertEquals(4, instance.navtiveMethod());
        // 用Expectations无法mock private方法
        Assert.assertEquals(5, instance.callPrivateMethod());

        Assert.assertEquals(2, new AnOrdinaryClass().ordinaryMethod());
    }

    @BeforeClass
    // 加载AnOrdinaryClass类的native方法的native实现
    public static void loadNative() throws Throwable {
        //JNITools.loadNative();
    }
}
