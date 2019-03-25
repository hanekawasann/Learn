package com.yukms.learn.testng.annotation;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * yukms 763803382@qq.com 2019/3/25 16:31
 */
public class GroupsTest {

    @BeforeGroups(groups = "Groups3")
    public void beforeGroups() {
        System.out.println("@BeforeGroups Groups3");
    }

    @AfterGroups(groups = "Groups3")
    public void afterGroups() {
        System.out.println("@AfterGroups Groups3");
    }

    @Test(groups = "01")
    public void test_method_01() {
        System.out.println("01 test_method_01");
    }

    @Test(groups = "02")
    public void test_method_02() {
        System.out.println("02 test_method_02");
    }

    @Test(groups = "03", dependsOnGroups = { "01", "02" })
    public void test_method_03() {
        System.out.println("03 test_method_03");
    }

    @Test(groups = "04")
    public void test_method_04() {
        System.out.println("04 test_method_04");
        throw new RuntimeException();
    }

    /**
     * {@link Test}的属性不可跨类使用
     */
    @Test(groups = "05", dependsOnGroups = { "01", "02", "04" })
    public void test_method_05() {
        System.out.println("05 test_method_05");
    }

    @Test(dependsOnMethods = "test_method_04")
    public void test_method_06() {
        System.out.println("test_method_06");
    }

}
