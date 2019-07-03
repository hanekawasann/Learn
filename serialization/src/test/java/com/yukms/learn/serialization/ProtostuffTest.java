package com.yukms.learn.serialization;

import java.io.IOException;

import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/7/3 18:28
 */
public class ProtostuffTest {
    @Test
    public void test_general_obj() throws IOException {
        People people = new People();
        people.setName("yukms");
        people.setAge(18);
        String path = "src/test/resource/protostuff/generalObj.bin";

        //Assert.assertEquals("yukms", read.getName());
        //Assert.assertEquals(18, read.getAge());
    }
}
