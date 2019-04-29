package com.yukms.learn.jmockit._03capturing;

import java.lang.reflect.Proxy;

import com.yukms.learn.jmockit.IPrivilege;
import mockit.Capturing;
import mockit.Expectations;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yukms 763803382@qq.com 2019/4/29 14:58
 */
public class CapturingTest {
    private long testUserId = 123456L;
    private IPrivilege privilegeManager1 = userId -> userId != testUserId;
    private IPrivilege privilegeManager2 = (IPrivilege) Proxy.newProxyInstance(//
        IPrivilege.class.getClassLoader(),//
        new Class[] { IPrivilege.class },//
        (proxy, method, args) -> (long) args[0] != testUserId);

    @Test
    public void testCaputring(@Capturing IPrivilege privilegeManager) {
        new Expectations() {
            {
                privilegeManager.isAllow(testUserId);
                result = true;
            }
        };
        Assert.assertTrue(privilegeManager1.isAllow(testUserId));
        //Assert.assertTrue(privilegeManager2.isAllow(testUserId));
    }

    @Test
    public void testWithoutCaputring() {
        Assert.assertTrue(!privilegeManager1.isAllow(testUserId));
        //Assert.assertTrue(!privilegeManager2.isAllow(testUserId));
    }
}
