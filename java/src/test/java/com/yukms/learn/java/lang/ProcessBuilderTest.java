package com.yukms.learn.java.lang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/9/16 15:25
 */
public class ProcessBuilderTest {
    @Test
    public void test_start() throws IOException {
        Process process = new ProcessBuilder("ipconfig").start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
        List<String> lines = reader.lines().collect(Collectors.toList());
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
