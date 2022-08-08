package com.hmm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author hmm
 * @Date 2021/9/17 14:22
 */

@RequestMapping("/test")
@RestController
public class testController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @RequestMapping("/test01")
    public String test01(String username) {
        String url = "http://127.0.0.1:8080/query?username=" + username;
        String forObject = this.restTemplate.getForObject(url, String.class);
        System.out.println(forObject);
        return forObject;
    }

    @RequestMapping("/test02")
    public String test02(String name) {
        ServiceInstance hmm = loadBalancerClient.choose("hmm");
        StringBuilder sb = new StringBuilder();
        sb.append("http://")
            .append(hmm.getHost())
            .append(":")
            .append(hmm.getPort())
            .append("/work?username=")
            .append(name);
        System.out.println(sb);
        String forObject = restTemplate.getForObject(String.valueOf(sb), String.class);

        return forObject;
    }
}
