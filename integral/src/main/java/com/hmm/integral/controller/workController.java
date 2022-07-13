package com.hmm.integral.controller;

import com.hmm.integral.entity.Inte;
import com.hmm.integral.service.inteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author hmm
 * @Date 2021/9/23 16:49
 */
@Controller
@ResponseBody
public class workController {
    @Autowired
    inteServiceImpl inteService;

    @GetMapping("/work")
    public Integer work(String username){
        Inte user = inteService.query(username);
        System.out.println("运行了");
        if (user==null){
            return 0;
        }
        return user.getNumber();
    }
}
