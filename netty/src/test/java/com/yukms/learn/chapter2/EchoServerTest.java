package com.yukms.learn.chapter2;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/10/16 17:32
 */
public class EchoServerTest {
    public static void main(String[] args) throws Exception {
        new EchoServer(4554).start();
    }
}
