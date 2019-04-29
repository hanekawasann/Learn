package com.yukms.learn.jmockit._02mocked_mockup_tested_injectable;

import java.util.Calendar;
import java.util.Locale;

import mockit.Mock;
import mockit.MockUp;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yukms 763803382@qq.com 2019/4/29 16:17
 */
public class MockUpTest {
    @Test
    public void testMockUp() {
        new MockUp<Calendar>(Calendar.class) {
            // 没有@Mock的方法，不受影响
            @Mock
            public int get(int unit) {
                if (unit == Calendar.YEAR) {
                    return 2017;
                }
                if (unit == Calendar.MONTH) {
                    return 12;
                }
                if (unit == Calendar.DAY_OF_MONTH) {
                    return 25;
                }
                if (unit == Calendar.HOUR_OF_DAY) {
                    return 7;
                }
                return 0;
            }
        };
        Calendar cal = Calendar.getInstance(Locale.FRANCE);
        Assert.assertEquals(2017, cal.get(Calendar.YEAR));
        Assert.assertEquals(12, cal.get(Calendar.MONTH));
        Assert.assertEquals(25, cal.get(Calendar.DAY_OF_MONTH));
        Assert.assertEquals(7, cal.get(Calendar.HOUR_OF_DAY));
        Assert.assertTrue((cal.getFirstDayOfWeek() == Calendar.MONDAY));

    }
}
