package com.yukms.learn.java.thread_local.same;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/7/18 9:57
 */
public class UserDao {
    public User getUser() {
        return UserService.THREAD_LOCAL.get();
    }
}
