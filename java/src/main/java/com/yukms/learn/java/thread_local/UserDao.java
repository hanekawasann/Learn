package com.yukms.learn.java.thread_local;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/7/18 9:57
 */
public class UserDao {
    private ThreadLocal<User> THREAD_LOCAL = ThreadLocal.withInitial(User::new);

    public User getUser() {
        return THREAD_LOCAL.get();
    }
}
