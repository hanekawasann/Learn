package com.yukms.learn.jmockit;

/**
 * @author yukms 763803382@qq.com 2019/4/29 14:45
 */
public interface MailService {
    boolean sendMail(long userId, String content);
}
