package com.yukms.learn.jmockit;

import javax.annotation.Resource;

/**
 * @author yukms 763803382@qq.com 2019/4/29 14:46
 */
public class OrderService {
    private MailService mailService;
    @Resource
    private UserCheckService userCheckService;

    public OrderService(MailService mailService) {
        this.mailService = mailService;
    }

    public boolean submitOrder(long buyerId, long itemId) {
        if (!userCheckService.check(buyerId)) {
            return false;
        }
        // ...
        return this.mailService.sendMail(buyerId, "下单成功");
    }
}
