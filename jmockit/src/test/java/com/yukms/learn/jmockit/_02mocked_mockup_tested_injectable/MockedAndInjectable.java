package com.yukms.learn.jmockit._02mocked_mockup_tested_injectable;

import java.util.Locale;

import mockit.Injectable;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yukms 763803382@qq.com 2019/4/29 14:42
 */
public class MockedAndInjectable {
    @Test
    public void testMocked(@Mocked Locale locale) {
        Assert.assertNull(Locale.getDefault());
        Assert.assertNull(locale.getCountry());
        Locale chinaLocale = new Locale("zh", "CN");
        Assert.assertNull(chinaLocale.getCountry());
    }

    @Test
    public void testInjectable(@Injectable Locale locale) {
        Assert.assertNotNull(Locale.getDefault());
        Assert.assertNull(locale.getCountry());
        Locale chinaLocale = new Locale("zh", "CN");
        Assert.assertEquals("CN", chinaLocale.getCountry());
    }
}
