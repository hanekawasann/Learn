package com.yukms.learn.yaml;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/6/27 18:25
 */
public class YamlTest {
    @Test
    public void test_01() throws IOException {
        People people = new People();
        people.setName("yukms");
        people.setAge(18);
        YamlWriter writer = new YamlWriter(new FileWriter("src/test/resource/yamlFile01.yaml"));
        writer.write(people);
        writer.close();

        YamlReader reader = new YamlReader(new FileReader("src/test/resource/yamlFile01.yaml"));
        //People read = reader.read(People.class);
        People read = (People) reader.read();
        Assert.assertEquals("yukms", read.getName());
        Assert.assertEquals(18, read.getAge());
    }

    @Test
    public void test_02() throws IOException {
        Teacher teacher = new Teacher();
        teacher.setName("teacher");
        teacher.setAge(18);
        Student student = new Student();
        student.setName("student");
        student.setAge(18);
        student.setTeacherName("teacher");

        List<People> people = new ArrayList<>();
        people.add(teacher);
        people.add(student);
        YamlWriter writer = new YamlWriter(new FileWriter("src/test/resource/yamlFile02.yaml"));
        writer.write(people);
        writer.close();

        YamlReader reader = new YamlReader(new FileReader("src/test/resource/yamlFile02.yaml"));
        List<People> read = (List<People>) reader.read();
        Assert.assertEquals(2, read.size());
        Teacher read_0 = (Teacher) read.get(0);
        Assert.assertEquals("teacher", read_0.getName());
        Assert.assertEquals(18, read_0.getAge());
        Student read_1 = (Student)read.get(1);
        Assert.assertEquals("student", read_1.getName());
        Assert.assertEquals(18, read_1.getAge());
        Assert.assertEquals("teacher", read_1.getTeacherName());
    }

    @Test
    public void test_03() throws IOException {
        Teacher teacher = new Teacher();
        teacher.setName("teacher");
        teacher.setAge(18);

        List<People> people = new ArrayList<>();
        people.add(teacher);
        people.add(teacher);
        YamlWriter writer = new YamlWriter(new FileWriter("src/test/resource/yamlFile03.yaml"));
        writer.write(people);
        writer.close();

        YamlReader reader = new YamlReader(new FileReader("src/test/resource/yamlFile03.yaml"));
        List<People> read = (List<People>) reader.read();
        Assert.assertEquals(2, read.size());
        Teacher read_0 = (Teacher) read.get(0);
        Assert.assertEquals("teacher", read_0.getName());
        Assert.assertEquals(18, read_0.getAge());
        People read_1 = read.get(1);
        Assert.assertSame(read_0, read_1);
    }
}
