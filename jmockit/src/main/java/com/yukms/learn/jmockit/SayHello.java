package com.yukms.learn.jmockit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yukms 763803382@qq.com 2019/4/29 18:35
 */
public class SayHello implements ISayHello {
    @Override
    public String sayHello(String who, int gender) {
        if (gender != FEMALE) {
            if (gender != MALE) {
                throw new IllegalArgumentException("illegal gender");
            }
        }
        switch (gender) {
            case FEMALE:
                return "hello Mrs " + who;
            case MALE:
                return "hello Mr " + who;
            default:
                return "hello  " + who;
        }
    }

    @Override
    public List<String> sayHello(String[] who, int[] gender) {
        if (who == null || gender == null) {
            return null;
        }
        if (who.length != gender.length) {
            throw new IllegalArgumentException();
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < gender.length; i++) {
            result.add(sayHello(who[i], gender[i]));
        }
        return result;
    }
}
