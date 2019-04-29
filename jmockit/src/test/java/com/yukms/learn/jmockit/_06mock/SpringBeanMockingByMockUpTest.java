package com.yukms.learn.jmockit._06mock;

import javax.annotation.Resource;

import com.yukms.learn.jmockit.AnOrdinaryClass;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;

/**
 * @author yukms 763803382@qq.com 2019/4/29 16:54
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "*.xml" })
public class SpringBeanMockingByMockUpTest {
    @Resource
    AnOrdinaryClass anOrdinaryBean;

    @Ignore
    public void testSpringBeanMockingByMockUp() {
        Assert.assertEquals(10, AnOrdinaryClass.staticMethod());
        Assert.assertEquals(20, anOrdinaryBean.ordinaryMethod());
        Assert.assertEquals(30, anOrdinaryBean.finalMethod());
        // native方法被mock了
        //Assert.assertEquals(40, anOrdinaryBean.navtiveMethod());
        // private方法被mock了
        Assert.assertEquals(50, anOrdinaryBean.callPrivateMethod());
    }

    @BeforeClass
    public static void beforeClassMethods() throws Throwable {
        loadNative();
        // 必须在Spring容器初始化前，就对Spring Bean的类做MockUp
        addMockUps();
    }

    // 加载AnOrdinaryClass类的native方法的native实现
    private static void loadNative() throws Throwable {
        //JNITools.loadNative();
    }

    private static void addMockUps() {
        new AnOrdinaryClassMockUp();
    }

    public static class AnOrdinaryClassMockUp extends MockUp<AnOrdinaryClass> {
        @Mock
        public static int staticMethod() {
            return 10;
        }

        @Mock
        public int ordinaryMethod() {
            return 20;
        }

        @Mock
        public final int finalMethod() {
            return 30;
        }

        @Mock
        public int navtiveMethod() {
            return 40;
        }

        @Mock
        private int privateMethod() {
            return 50;
        }
    }
}
