package com.yukms.learn.testng.annotation;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * yukms 763803382@qq.com 2019/3/25 17:02
 */
@Test
public class ParametersTest {

    /**
     * {@link Parameters}使用XML传递参数
     */
    @Parameters( { "age", "job" })
    public void test_method_01(int age, String job) {
        System.out.println(age + "岁 " + job + "desu");
    }

}
