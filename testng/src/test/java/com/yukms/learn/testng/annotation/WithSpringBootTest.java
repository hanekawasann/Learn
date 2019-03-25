package com.yukms.learn.testng.annotation;

import com.yukms.learn.testng.interview.IInterviewService;
import com.yukms.learn.testng.user.IUserService;
import com.yukms.learn.testng.user.entity.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * yukms 763803382@qq.com 2019/3/25 17:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WithSpringBootTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private IUserService userService;
    @Autowired
    private IInterviewService interviewService;

    @Test(dataProvider = "getId")
    public void test_introduce(int id) {
        User user = userService.getUser(id);
        interviewService.introduce(user);
    }

    @DataProvider
    public Object[][] getId() {
        return new Object[][] {//
            { 1 }//
        };
    }

}
