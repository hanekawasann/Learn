package com.yukms.learn.logback;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/7/10 11:01
 */
@Slf4j
public class LogbackTest {
    @Test
    public void test_info() {
        log.info("info");
    }

    @Test
    public void test_error() {
        try {
            throw new NoSuchMethodException("");
        } catch (NoSuchMethodException e) {
            log.error("error", e);
        }
    }
}
