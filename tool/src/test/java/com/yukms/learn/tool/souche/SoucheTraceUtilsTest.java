package com.yukms.learn.tool.souche;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2020/3/14 14:31
 */
public class SoucheTraceUtilsTest {
    @Test
    public void test_printQueryConfig() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("/logTraceidResult.htm");
        SoucheTraceUtils.printQueryConfig(inputStream);
    }

    @Test
    public void test_printQueryConfig_02() throws IOException {
        SoucheTraceUtils.printQueryConfig(new File("C:\\Users\\76380\\Desktop\\logTraceidResult.htm"));
    }
}