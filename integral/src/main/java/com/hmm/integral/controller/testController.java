package com.hmm.integral.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hmm
 * @Date 2021/9/22 13:35
 */
@RestController
@RefreshScope
public class testController {

    @Value("${from}")
    private String from;

    @RequestMapping("/test")
    public String test(){
        return from;
    }

}
