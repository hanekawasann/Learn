package com.yukms.learn.jmockit._08person.mock_super_class_static_attr;

import mockit.Capturing;
import mockit.Expectations;
import mockit.Tested;
import mockit.VerificationsInOrder;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yukms 763803382@qq.com 2019/5/14 18:49
 */
public class MockSuperClassStaticAttrTest {
    @Tested
    private PeopleUtils peopleUtils;
    @Capturing
    private People people;

    @Test
    public void test_01() {
        new Expectations() {
            {
                people.sayBay();
                result = "1";
            }
        };
        Assert.assertEquals("1", peopleUtils.sayBay());
        new VerificationsInOrder() {
            {
                people.sayBay();
                times = 1;
            }
        };
    }
}
