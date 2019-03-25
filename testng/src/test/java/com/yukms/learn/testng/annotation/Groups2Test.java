package com.yukms.learn.testng.annotation;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * yukms 763803382@qq.com 2019/3/25 16:31
 */
@Test(groups = "Groups2")
public class Groups2Test {

    @BeforeGroups(groups = "Groups2")
    public void beforeGroups() {
        System.out.println("@BeforeGroups Groups2");
    }

    @AfterGroups(groups = "Groups2")
    public void afterGroups() {
        System.out.println("@AfterGroups Groups2");
    }

    public void test_method_01() {
        System.out.println("Groups2 test_method_01");
    }

    public void test_method_02() {
        System.out.println("Groups2 test_method_02");
    }
}
