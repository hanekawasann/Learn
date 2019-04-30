package com.yukms.learn.jmockit._05verifications;

import java.util.List;

import mockit.Mocked;
import mockit.Verifications;
import org.junit.Test;

/**
 * @author yukms 763803382@qq.com 2019/4/30 14:26
 */
public class NewInstancesTest {
    @Test
    public void capturingNewInstances(@Mocked Person mockedPerson) {
        new Person("Paul", 10);
        new Person("Mary", 15);
        new Person("Joe", 20);

        new Verifications() {
            {
                List<Person> peoples = withCapture(new Person(anyString, anyInt));
            }
        };
    }

    private static class Person {
        private String name;
        private int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
