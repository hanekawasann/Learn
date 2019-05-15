package com.yukms.learn.jmockit._08person.parameter_matching;

import mockit.Expectations;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yukms 763803382@qq.com 2019/5/15 15:18
 */
public class ParameterMatching {
    @Mocked
    private People people;

    @Test
    public void test_say_success() {
        new Expectations(){
            {
                people.say(new Message("yukms"));
                result = new Message("yukms");
            }
        };
        Message result = people.say(new Message("yukms"));
        Assert.assertEquals("yukms", result.getContent());
    }

    @Test(expected = Throwable.class)
    public void test_say_fail() {
        new Expectations(){
            {
                people.say(new Message("yukms"));
                result = new Message("yukms");
            }
        };
        Message result = people.say(new Message("lain"));
        Assert.assertEquals("yukms", result.getContent());
    }
}
