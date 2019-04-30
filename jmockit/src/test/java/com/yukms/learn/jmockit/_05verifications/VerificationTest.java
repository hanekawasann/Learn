package com.yukms.learn.jmockit._05verifications;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import mockit.Expectations;
import mockit.Verifications;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yukms 763803382@qq.com 2019/4/29 16:21
 */
public class VerificationTest {
    @Test
    public void testVerification() {
        Calendar calendar = Calendar.getInstance();
        new Expectations(Calendar.class) {
            {
                calendar.get(Calendar.YEAR);
                result = 2016;
                calendar.get(Calendar.HOUR_OF_DAY);
                result = 7;
            }
        };
        Calendar now = Calendar.getInstance();
        Assert.assertEquals(2016, now.get(Calendar.YEAR));
        Assert.assertEquals(7, now.get(Calendar.HOUR_OF_DAY));
        new Verifications() {
            {
                Calendar.getInstance();
                times = 1;
                calendar.get(Calendar.YEAR);
                times = 1;
                calendar.get(Calendar.HOUR_OF_DAY);
                times = 1;
                //calendar.get(anyInt);
                //times = 2;
            }
        };

    }
}
