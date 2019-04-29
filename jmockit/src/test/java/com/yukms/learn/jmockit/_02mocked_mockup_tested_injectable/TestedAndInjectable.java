package com.yukms.learn.jmockit._02mocked_mockup_tested_injectable;

import com.yukms.learn.jmockit.MailService;
import com.yukms.learn.jmockit.OrderService;
import com.yukms.learn.jmockit.UserCheckService;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yukms 763803382@qq.com 2019/4/29 14:49
 */
public class TestedAndInjectable {
    @Tested
    private OrderService orderService;
    @Injectable
    private MailService mailService;
    @Injectable
    private UserCheckService userCheckService;
    private long testUserId = 123456L;

    @Test
    public void testSubmitOrder() {
        new Expectations() {
            {
                mailService.sendMail(testUserId, anyString);
                result = true;
                userCheckService.check(testUserId);
                result = true;
            }
        };
        long testItemId = 456789L;
        Assert.assertTrue(orderService.submitOrder(testUserId, testItemId));
    }
}
