package com.yukms.learn.jmockit._06mock;

import com.yukms.learn.jmockit.AnOrdinaryClass;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author yukms 763803382@qq.com 2019/4/29 16:34
 */
public class ClassMockingByMockUpTest {
    // AnOrdinaryClass的MockUp类，继承MockUp即可
    private static class AnOrdinaryClassMockUp extends MockUp<AnOrdinaryClass> {
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

    @Test
    public void testClassMockingByMockUp() {
        new AnOrdinaryClassMockUp();
        AnOrdinaryClass instance = new AnOrdinaryClass();
        Assert.assertEquals(10, AnOrdinaryClass.staticMethod());
        Assert.assertEquals(20, instance.ordinaryMethod());
        Assert.assertEquals(30, instance.finalMethod());
        // native方法被mock了
        Assert.assertEquals(40, instance.navtiveMethod());
        // private方法被mock了
        Assert.assertEquals(50, instance.callPrivateMethod());
    }

    @BeforeClass
    // 加载AnOrdinaryClass类的native方法的native实现
    public static void loadNative() throws Throwable {
        //JNITools.loadNative();
    }
}
