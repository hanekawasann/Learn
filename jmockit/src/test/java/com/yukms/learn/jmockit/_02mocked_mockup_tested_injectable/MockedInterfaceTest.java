package com.yukms.learn.jmockit._02mocked_mockup_tested_injectable;

import javax.servlet.http.HttpSession;

import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yukms 763803382@qq.com 2019/4/29 14:39
 */
public class MockedInterfaceTest {
    @Mocked
    private HttpSession session;

    @Test
    public void testMockedInterface() {
        Assert.assertNull(session.getId());
        Assert.assertEquals(0L, session.getCreationTime());
        Assert.assertNotNull(session.getServletContext());
        Assert.assertNull(session.getServletContext().getContextPath());
    }
}
