package com.yukms.learn.jmockit;

import java.util.Locale;

/**
 * @author yukms 763803382@qq.com 2019/4/29 11:32
 */
public class HelloJMockit {
    public String sayHello() {
        Locale locale = Locale.getDefault();
        if (locale.equals(Locale.CHINA)) {
            return "你好，JMockit!";
        } else {
            return "Hello，JMockit!";
        }
    }
}
