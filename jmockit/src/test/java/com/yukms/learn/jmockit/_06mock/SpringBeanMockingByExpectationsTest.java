package com.yukms.learn.jmockit._06mock;


import javax.annotation.Resource;

import com.yukms.learn.jmockit.AnOrdinaryClass;
import mockit.Expectations;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author yukms 763803382@qq.com 2019/4/29 16:53
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "*.xml" })
public class SpringBeanMockingByExpectationsTest {
    @Resource
    AnOrdinaryClass anOrdinaryBean;

    @Ignore
    public void testSpringBeanMockingByExpectation() {
        // 直接把实例传给Expectations的构造函数即可Mock这个实例
        new Expectations(anOrdinaryBean) {
            {
                // 尽管这里也可以Mock静态方法，但不推荐在这里写。静态方法的Mock应该是针对类的
                // mock普通方法
                anOrdinaryBean.ordinaryMethod();
                result = 20;
                // mock final方法
                anOrdinaryBean.finalMethod();
                result = 30;
                // native, private方法无法用Expectations来Mock
            }
        };
        Assert.assertEquals(1, AnOrdinaryClass.staticMethod());
        Assert.assertEquals(20, anOrdinaryBean.ordinaryMethod());
        Assert.assertEquals(30, anOrdinaryBean.finalMethod());
        // 用Expectations无法mock native方法
        //Assert.assertEquals(4, anOrdinaryBean.navtiveMethod());
        // 用Expectations无法mock private方法
        Assert.assertEquals(5, anOrdinaryBean.callPrivateMethod());
    }

    @BeforeClass
    // 加载AnOrdinaryClass类的native方法的native实现
    public static void loadNative() throws Throwable {
        //JNITools.loadNative();
    }
}
