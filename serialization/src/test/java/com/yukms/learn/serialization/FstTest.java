package com.yukms.learn.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.nustaq.serialization.FSTObjectInput;
import org.nustaq.serialization.FSTObjectOutput;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/7/3 18:20
 */
public class FstTest {
    @Test
    public void test_general_obj() throws IOException, ClassNotFoundException {
        People people = new People();
        people.setName("yukms");
        people.setAge(18);
        String path = "src/test/resource/fst/generalObj.bat";
        FSTObjectOutput out = new FSTObjectOutput(new FileOutputStream(path));
        out.writeObject(people);
        out.close(); // required !


        FSTObjectInput in = new FSTObjectInput(new FileInputStream(path));
        People read = (People) in.readObject();
        in.close(); // required !

        Assert.assertEquals("yukms", read.getName());
        Assert.assertEquals(18, read.getAge());
    }
}
