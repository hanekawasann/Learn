package com.yukms.learn.testng.annotation;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * yukms 763803382@qq.com 2019/3/25 16:19
 */
public class Groups1Test {

    /**
     * {@link BeforeGroups}与{@link AfterGroups}不能跨类使用
     */
    @BeforeGroups(groups = "Group1")
    public void beforeGroups() {
        System.out.println("@BeforeGroups Group1");
    }

    @AfterGroups(groups = "Group1")
    public void afterGroups() {
        System.out.println("@AfterGroups Group1");
    }

    @Test(groups = "Group1")
    public void test_method_01() {
        System.out.println("Groups1 test_method_01");
    }

    @Test(groups = "Group1")
    public void test_method_02() {
        System.out.println("Groups1 test_method_02");
    }

}
