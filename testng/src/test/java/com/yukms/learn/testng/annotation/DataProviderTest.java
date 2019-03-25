package com.yukms.learn.testng.annotation;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * yukms 763803382@qq.com 2019/3/25 17:07
 */
public class DataProviderTest {

    @Test(dataProvider = "user")
    public void test_method_01(int age, String job) {
        System.out.println(age + "岁 " + job + "desu");
    }

    /**
     * {@link DataProvider}使用代码传递参数
     * <br>
     * {@link Method}表示当前执行的方法
     * {@link ITestContext}存放分组等信息
     */
    @DataProvider(name = "user")
    public Object[][] dataProvider1(Method method, ITestContext context) {
        return new Object[][] {//
            { 24, "学生" },//
            { 24, "野兽" }//
        };
    }

    @Test(dataProvider = "map")
    public void test_method_02(Map<String, String> map) {
        System.out.println(map.get("age") + "岁 " + map.get("job") + "desu");
    }

    @DataProvider(name = "map")
    public Object[][] dataProvider2() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("age", "24");
        map1.put("job", "学生");
        Map<String, String> map2 = new HashMap<>();
        map2.put("age", "24");
        map2.put("job", "野兽");
        return new Object[][] {//
            { map1 },//
            { map2 }//
        };
    }

    @Test(dataProvider = "dataProvider3")
    public void test_method_03(Map<String, String> map) {
        System.out.println(map.get("age") + "岁 " + map.get("job") + "desu");
    }

    @DataProvider
    public Object[][] dataProvider3() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("age", "24");
        map1.put("job", "学生");
        Map<String, String> map2 = new HashMap<>();
        map2.put("age", "24");
        map2.put("job", "野兽");
        return new Object[][] {//
            { map1 },//
            { map2 }//
        };
    }

}
