package com.hmm.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author hmm
 * @Date 2021/10/18 14:01
 */
@FeignClient(value = "inte")
public interface inteService {
    @RequestMapping("/work")
    String work(@RequestParam(value = "username") String username);
}
