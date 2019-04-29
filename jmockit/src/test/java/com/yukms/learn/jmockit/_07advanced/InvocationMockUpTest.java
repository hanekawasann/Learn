package com.yukms.learn.jmockit._07advanced;

import java.util.Calendar;
import java.util.Date;

import mockit.Invocation;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yukms 763803382@qq.com 2019/4/29 18:30
 */
public class InvocationMockUpTest {
    @Test
    public void testMockUp() {
        new MockUp<Calendar>(Calendar.class) {
            // 申明参数invocation，表示老方法的调用
            @Mock
            public int get(Invocation invocation, int unit) {
                if (unit == Calendar.HOUR_OF_DAY) {
                    return 7;
                }
                return invocation.proceed(unit);
            }
        };
        Calendar now = Calendar.getInstance();
        Assert.assertEquals(7, now.get(Calendar.HOUR_OF_DAY));
        Assert.assertEquals(now.get(Calendar.MONTH), (new Date()).getMonth());
        Assert.assertEquals(now.get(Calendar.DAY_OF_MONTH), (new Date()).getDate());
    }
}
