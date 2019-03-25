package com.yukms.swagger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * yukms 763803382@qq.com 2019/3/20 18:24
 */
@RestController
public class SystemController {

    @RequestMapping("/index")
    public String index() {
        return "Welcome!";
    }

}
