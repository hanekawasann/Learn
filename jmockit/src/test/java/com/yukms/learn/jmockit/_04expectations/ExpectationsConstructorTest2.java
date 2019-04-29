package com.yukms.learn.jmockit._04expectations;

import java.util.Calendar;
import java.util.Date;

import mockit.Expectations;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yukms 763803382@qq.com 2019/4/29 16:09
 */
public class ExpectationsConstructorTest2 {
    @Test
    public void testRecordConstrutctor1() {
        Calendar calendar = Calendar.getInstance();
        new Expectations(Calendar.class) {
            {
                calendar.get(Calendar.HOUR_OF_DAY);
                result = 7;
            }
        };
        Calendar now = Calendar.getInstance();
        Assert.assertEquals(7, now.get(Calendar.HOUR_OF_DAY));
        Assert.assertEquals(now.get(Calendar.DAY_OF_MONTH), (new Date()).getDate());
    }

    @Test
    public void testRecordConstrutctor2() {
        Calendar cal = Calendar.getInstance();
        // 只对这个对象影响
        new Expectations(cal) {
            {
                cal.get(Calendar.HOUR_OF_DAY);
                result = 7;
            }
        };

        Assert.assertEquals(7, cal.get(Calendar.HOUR_OF_DAY));
        Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), (new Date()).getDate());

        Calendar now = Calendar.getInstance();
        Assert.assertEquals(now.get(Calendar.HOUR_OF_DAY), (new Date()).getHours());
        Assert.assertEquals(now.get(Calendar.DAY_OF_MONTH), (new Date()).getDate());
    }
}
