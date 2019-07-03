package com.yukms.learn.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/7/3 18:10
 */
public class KryoTest {
    @Test
    public void test_general_obj() throws IOException {
        People people = new People();
        people.setName("yukms");
        people.setAge(18);
        String path = "src/test/resource/kryo/generalObj.bat";
        Output output = new Output(new FileOutputStream(path));
        Kryo kryo = new Kryo();
        kryo.register(People.class);
        kryo.writeObject(output, people);
        output.close();

        Input input = new Input(new FileInputStream(path));
        People read = kryo.readObject(input, People.class);
        Assert.assertEquals("yukms", read.getName());
        Assert.assertEquals(18, read.getAge());
    }
}
