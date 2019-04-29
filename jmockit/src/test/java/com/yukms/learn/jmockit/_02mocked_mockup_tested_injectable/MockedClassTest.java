package com.yukms.learn.jmockit._02mocked_mockup_tested_injectable;

import java.util.Locale;

import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yukms 763803382@qq.com 2019/4/29 14:37
 */
public class MockedClassTest {
    @Mocked
    private Locale locale;

    @Test
    public void testMockedClass() {
        Assert.assertNull(Locale.getDefault());
        Assert.assertNull(locale.getCountry());
        Locale chinaLocale = new Locale("zh", "CN");
        Assert.assertNull(chinaLocale.getCountry());
    }
}
