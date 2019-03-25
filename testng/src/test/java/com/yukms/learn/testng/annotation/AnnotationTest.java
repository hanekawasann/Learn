package com.yukms.learn.testng.annotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * yukms 763803382@qq.com 2019/3/25 15:42
 */
public class AnnotationTest {

    @BeforeClass
    public void beforeClass() {
        System.out.println("@BeforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("@AfterClass");
    }

    @Test(expectedExceptions = Exception.class)
    public void expectedExceptionsOfTest() {
        System.out.println("expectedExceptionsOfTest");
        throw new RuntimeException();
    }

    @Test(enabled = false)
    public void enabledOfTest() {
        System.out.println("enabledOfTest");
        throw new RuntimeException();
    }

    @Test(timeOut = 2000)
    public void timeOutOfTest() throws InterruptedException {
        Thread.sleep(1000);
    }

}
