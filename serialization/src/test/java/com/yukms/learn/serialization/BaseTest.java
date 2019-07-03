package com.yukms.learn.serialization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/7/3 17:36
 */
public class BaseTest {
    protected List<People> getSubclassesOfPeople() {
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
        return people;
    }

    protected String getFileString(File file) throws IOException {
        StringBuilder builder = new StringBuilder(64);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        String s = builder.toString();
        reader.close();
        return s;
    }

    protected void setFileString(File file, String s) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(s);
        writer.close();
    }
}
