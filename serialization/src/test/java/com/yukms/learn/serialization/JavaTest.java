package com.yukms.learn.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/7/3 17:45
 */
public class JavaTest extends BaseTest {
    @Test
    public void test_subclass_obj() throws IOException, ClassNotFoundException {
        List<People> people = getSubclassesOfPeople();

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src/test/resource/java/subclassObj.bat"));
        outputStream.writeObject(people);
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("src/test/resource/java/subclassObj.bat"));
        List<People> read = (List<People>) inputStream.readObject();
        inputStream.close();

        Assert.assertEquals(2, read.size());
        Teacher read_0 = (Teacher) read.get(0);
        Assert.assertEquals("teacher", read_0.getName());
        Assert.assertEquals(18, read_0.getAge());
        Student read_1 = (Student) read.get(1);
        Assert.assertEquals("student", read_1.getName());
        Assert.assertEquals(18, read_1.getAge());
        Assert.assertEquals("teacher", read_1.getTeacherName());
    }
}
