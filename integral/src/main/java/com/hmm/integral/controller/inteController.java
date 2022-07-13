package com.hmm.integral.controller;

import com.hmm.integral.entity.Inte;
import com.hmm.integral.service.inteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author hmm
 * @Date 2021/9/17 18:36
 */
@Controller
public class inteController {

    @Autowired
    inteServiceImpl inteService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/query")
    public String query(Inte inte, Model model, HttpSession session){
        Inte query = inteService.query(inte.getUsername());
        if (query==null){
            model.addAttribute("msg","查询不到当前用户");
            return "index";
        }
        model.addAttribute("username",query.getUsername());
        if (query.getNumber()==null)
            model.addAttribute("number",0);
        else
            model.addAttribute("number",query.getNumber());
        session.setAttribute("username",query.getUsername());
        return "query";
    }

    @RequestMapping("/change")
    public String change(Integer number,HttpSession session,Model model){
        String username = (String) session.getAttribute("username");
        if (session.getAttribute("username")==null){
            model.addAttribute("msg","识别不出当前用户");
            return "index";
        }
        inteService.change(number, username);
        Inte query = inteService.query(username);
        model.addAttribute("number",query.getNumber());
        model.addAttribute("username",query.getUsername());
        return "query";
    }
}
