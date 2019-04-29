package com.yukms.learn.jmockit._01base;

import com.yukms.learn.jmockit.HelloJMockit;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yukms 763803382@qq.com 2019/4/29 13:57
 */
public class ProgramConstructureTest {
    @Mocked
    private HelloJMockit helloJMockit;

    @Test
    public void test1() {
        new Expectations() {
            {
                helloJMockit.sayHello();
                result = "1";
            }
        };
        String msg = helloJMockit.sayHello();
        Assert.assertEquals("1", msg);
        new Verifications() {
            {
                helloJMockit.sayHello();
                times = 1;
            }
        };
    }

    @Test
    public void test2(@Mocked HelloJMockit helloJMockit) {
        new Expectations() {
            {
                helloJMockit.sayHello();
                result = "2";
            }
        };
        String msg = helloJMockit.sayHello();
        Assert.assertEquals("2", msg);
        new Verifications() {
            {
                helloJMockit.sayHello();
                times = 1;
            }
        };
    }
}
