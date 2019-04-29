package com.yukms.learn.jmockit._07advanced;

import com.yukms.learn.jmockit.AnOrdinaryClassWithBlock;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yukms 763803382@qq.com 2019/4/29 17:56
 */
public class ConstructorAndBlockMockingTest {
    public static class AnOrdinaryClassWithBlockMockUp extends MockUp<AnOrdinaryClassWithBlock> {
        /** 构造函数和初始代码块 */
        @Mock
        public void $init(int i) { }

        /** 静态代码块 */
        @Mock
        public void $clinit() { }
    }

    @Test
    public void testClassMockingByMockUp() {
        new AnOrdinaryClassWithBlockMockUp();
        AnOrdinaryClassWithBlock instance = new AnOrdinaryClassWithBlock(10);
        Assert.assertEquals(0, AnOrdinaryClassWithBlock.j);
        Assert.assertEquals(0, instance.getI());
    }
}
