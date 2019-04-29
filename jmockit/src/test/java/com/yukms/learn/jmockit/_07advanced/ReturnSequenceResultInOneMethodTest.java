package com.yukms.learn.jmockit._07advanced;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import com.yukms.learn.jmockit.AnOrdinaryClass;
import mockit.Expectations;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yukms 763803382@qq.com 2019/4/29 22:49
 */
public class ReturnSequenceResultInOneMethodTest {
    // 一个类所有实例的某个方法，返回时序结果。
    @Test
    public void testIfMethodOfClass() {
        AnOrdinaryClass instance = new AnOrdinaryClass();
        new Expectations(AnOrdinaryClass.class) {
            {
                instance.ordinaryMethod();
                // 对类AnOrdinaryClass所有实例调用ordinaryMethod方法时，依次返回1，2，3，4，5
                result = new int[] { 1, 2, 3, 4, 5 };
            }
        };
        AnOrdinaryClass instance1 = new AnOrdinaryClass();
        Assert.assertEquals(1, instance1.ordinaryMethod());
        Assert.assertEquals(2, instance1.ordinaryMethod());
        Assert.assertEquals(3, instance1.ordinaryMethod());
        Assert.assertEquals(4, instance1.ordinaryMethod());
        Assert.assertEquals(5, instance1.ordinaryMethod());
        // 因为在上面录制脚本中，只录制了5个结果，当大于5时，就以最后一次结果为准
        Assert.assertEquals(5, instance1.ordinaryMethod());
        Assert.assertEquals(5, instance1.ordinaryMethod());
    }

    // 与上述不一样的地方，仅仅是对某一个实例的返回值进行录制
    @Test
    public void testIfMethodOfIntance() {
        AnOrdinaryClass instance = new AnOrdinaryClass();
        new Expectations(instance) {
            {
                instance.ordinaryMethod();
                result = new int[] { 1, 2, 3, 4, 5 };
            }
        };
        Assert.assertEquals(1, instance.ordinaryMethod());
        Assert.assertEquals(2, instance.ordinaryMethod());
        Assert.assertEquals(3, instance.ordinaryMethod());
        Assert.assertEquals(4, instance.ordinaryMethod());
        Assert.assertEquals(5, instance.ordinaryMethod());
        // 因为在上面录制脚本中，只录制了5个结果，当大于5时，就以最后一次结果为准
        Assert.assertEquals(5, instance.ordinaryMethod());
        Assert.assertEquals(5, instance.ordinaryMethod());

        // 类AnOrdinaryClass的其它实例并不会受到影响
        AnOrdinaryClass instance1 = new AnOrdinaryClass();
        // ordinaryMethod这个方法本来就返回2
        Assert.assertEquals(2, instance1.ordinaryMethod());
        Assert.assertEquals(2, instance1.ordinaryMethod());
    }
}
