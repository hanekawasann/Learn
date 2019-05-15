package com.yukms.learn.jmockit._08person.mock_super_class_static_attr;

/**
 * @author yukms 763803382@qq.com 2019/5/15 9:50
 */
public class PeopleImpl implements People {
    @Override
    public String sayHello() {
        return "Hello";
    }

    @Override
    public String sayBay() {
        return "Bay";
    }
}
