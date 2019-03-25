package com.yukms.learn.testng.user.impl;

import com.yukms.learn.testng.user.IUserService;
import com.yukms.learn.testng.user.entity.User;
import org.springframework.stereotype.Service;

/**
 * yukms 763803382@qq.com 2019/3/25 15:02
 */
@Service
public class UserServiceImpl implements IUserService {

    @Override
    public User getUser(int id) {
        if (id == 0) {
            throw new RuntimeException();
        }
        User user = new User();
        user.setId(1);
        user.setName("野兽先辈");
        user.setAge(24);
        user.setHobby("邀请后辈和红茶");
        return user;
    }

}
