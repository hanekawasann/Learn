package com.yukms.learn.jmockit._08person.mock_super_class_static_attr;

/**
 * @author yukms 763803382@qq.com 2019/5/14 18:49
 */
public abstract class AbstractPeopleUtils {
    protected static final People people = new PeopleImpl();

    protected abstract String sayBay();
}
