package com.yukms.learn.java.thread_local.diff;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/7/18 10:01
 */
public class UserServiceTest {
    private UserService service = new UserService();

    @Test
    public void test_getUser() {
        User user = service.getUser("yukms", 24);
        Assert.assertNull(user.getName());
        Assert.assertEquals(0, user.getAge());
    }
}