package com.yukms.learn.java.lang;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/9/16 15:07
 */
public class PackageTest {
    @Test
    public void test_getPackages() {
        Package[] packages = Package.getPackages();
        Arrays.stream(packages).forEach(aPackage -> System.out.println(aPackage.getName()));
    }
}
