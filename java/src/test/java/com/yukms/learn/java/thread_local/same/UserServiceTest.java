package com.yukms.learn.java.thread_local.same;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/7/18 10:06
 */
public class UserServiceTest {
    private UserService service = new UserService();

    @Test
    public void test_getUser() {
        User user = service.getUser("yukms", 24);
        Assert.assertEquals("yukms", user.getName());
        Assert.assertEquals(24, user.getAge());
    }
}