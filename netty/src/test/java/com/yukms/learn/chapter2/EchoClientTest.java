package com.yukms.learn.chapter2;

/**
 * @author hudingpeng hudingpeng@souche.com 2019/10/16 17:44
 */
public class EchoClientTest {
    public static void main(String[] args) throws Exception {
        new EchoClient("localhost", 4554).start();
    }
}