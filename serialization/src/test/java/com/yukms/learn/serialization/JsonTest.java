package com.yukms.learn.serialization;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/7/3 17:35
 */
public class JsonTest extends BaseTest {
    @Test
    public void test_subclass_obj() throws IOException {
        List<People> people = getSubclassesOfPeople();

        setFileString(new File("src/test/resource/json/subclassObj.json"), JSON.toJSONString(people, true));

        List<People> array = JSON.parseArray(getFileString(new File("src/test/resource/json/subclassObj.json")), People.class);
        assertTrue(array.get(0) instanceof People);
        assertFalse(array.get(0) instanceof Teacher);
        assertTrue(array.get(1) instanceof People);
        assertFalse(array.get(1) instanceof Student);
    }
}
