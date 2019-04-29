package com.yukms.learn.jmockit._06mock;

import com.yukms.learn.jmockit.AnOrdinaryInterface;
import mockit.Expectations;
import mockit.Injectable;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yukms 763803382@qq.com 2019/4/29 16:43
 */
public class InterfaceMockingByExpectationsTest {
    // 这里其实应该用@Mocked
    @Injectable
    private AnOrdinaryInterface anOrdinaryInterface;

    @Test
    public void testInterfaceMockingByExpectation() {
        new Expectations() {
            {
                anOrdinaryInterface.method1();
                result = 10;
                anOrdinaryInterface.method2();
                result = 20;
            }
        };
        Assert.assertEquals(10, anOrdinaryInterface.method1());
        Assert.assertEquals(20, anOrdinaryInterface.method2());
    }
}
