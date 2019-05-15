package com.yukms.learn.jmockit._08person.mock_super_class_static_attr;

/**
 * @author yukms 763803382@qq.com 2019/5/15 9:43
 */
public class PeopleUtils extends AbstractPeopleUtils {
    @Override
    public String sayBay() {
        return people.sayBay();
    }
}
