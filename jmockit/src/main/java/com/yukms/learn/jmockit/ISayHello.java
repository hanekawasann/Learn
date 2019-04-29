package com.yukms.learn.jmockit;

import java.util.List;

/**
 * @author yukms 763803382@qq.com 2019/4/29 18:35
 */
public interface ISayHello {
    int MALE = 0;
    int FEMALE = 1;

    String sayHello(String who, int gender);

    List<String> sayHello(String[] who, int[] gender);
}
