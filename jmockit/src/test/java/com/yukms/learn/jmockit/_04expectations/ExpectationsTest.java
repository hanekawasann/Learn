package com.yukms.learn.jmockit._04expectations;

import java.util.Calendar;

import mockit.Expectations;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yukms 763803382@qq.com 2019/4/29 16:06
 */
public class ExpectationsTest {
    @Mocked
    private Calendar calendar;

    @Test
    public void testRecordOutside() {
        new Expectations() {
            {
                calendar.get(Calendar.YEAR);
                result = 2016;
                calendar.get(Calendar.HOUR_OF_DAY);
                result = 7;
            }
        };
        Assert.assertEquals(2016, calendar.get(Calendar.YEAR));
        Assert.assertEquals(7, calendar.get(Calendar.HOUR_OF_DAY));
        Assert.assertEquals(0, calendar.get(Calendar.DAY_OF_MONTH));
    }
}
