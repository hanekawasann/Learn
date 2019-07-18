package com.yukms.learn.java.thread_local;

import lombok.Data;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/7/18 9:56
 */
@Data
public class UserService {
    private ThreadLocal<User> THREAD_LOCAL = ThreadLocal.withInitial(User::new);
    private UserDao userDao = new UserDao();

    public User getUser(String name, int age) {
        User user = THREAD_LOCAL.get();
        user.setName(name);
        user.setAge(age);
        return userDao.getUser();
    }
}
