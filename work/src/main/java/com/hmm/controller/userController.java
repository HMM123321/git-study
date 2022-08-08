package com.hmm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hmm.entity.User;
import com.hmm.service.inteService;
import com.hmm.service.userServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.*;

/**
 * @Author hmm
 * @Date 2021/9/8 15:59
 */

@RequestMapping(value = "/user", produces = "text/plain;charset=UTF-8")
@Controller
public class userController {

    @Autowired
    userServiceImpl userService;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    inteService inteservice;

    @Value("${hmm.name}")
    private String name;

    @RequestMapping("/index")
    public String index(HttpSession httpSession, Model model) {
        Object username = httpSession.getAttribute("username");
        if (username == null)
            return "login";
        if (username.equals("admin"))
            model.addAttribute("msg", "管理员");
        else
            model.addAttribute("msg", "普通用户");
        model.addAttribute("username", httpSession.getAttribute("username"));
        return "index";
    }

    @RequestMapping("/login")
    public ModelAndView login(User user, Model model, HttpSession httpSession) {
        ModelAndView mv = new ModelAndView();
        User login = userService.login(user.getUsername(), user.getPassword());
        if (login != null && user.getUsername().equals("admin")) {
            model.addAttribute("msg", "管理员登录成功");
            mv.setViewName("index");
            httpSession.setAttribute("username", user.getUsername());
        } else if (login != null) {
            model.addAttribute("msg", "普通用户登录成功");
            mv.setViewName("index");
            httpSession.setAttribute("username", user.getUsername());
        } else {
            model.addAttribute("msg", "账户或密码错误");
            mv.setViewName("login");
        }
        if (login != null)
            model.addAttribute("name", user.getUsername());
        return mv;
    }

    @RequestMapping("/register")
    public String register(User user, Model model) {
        if (user.getUsername() == null || user.getPassword() == null) {
            model.addAttribute("msg", "请输入注册的用户名密码");
            return "register";
        }
        if (userService.find(user.getUsername()) != null) {
            model.addAttribute("msg", "用户名已存在，请重新输入");
            return "register";
        }
        userService.register(user.getUsername(), user.getPassword());
        model.addAttribute("msg", "用户注册成功");
        return "login";
    }

    @RequestMapping("/query")
    public String query(Model model, HttpSession httpSession) {
        Object username = httpSession.getAttribute("username");
        model.addAttribute("username", username);
        if (username == null) {
            model.addAttribute("msg", "用户未登录");
            return "login";
        }
        List<User> users = userService.query();
//        for (User user : users) {
//            try {
//
//                String number = inteservice.work(user.getUsername());
//                System.out.println(number);
//                user.setNumber(number);
//            } catch (Exception e){
//                System.err.println(e);
//                user.setNumber("network error");
//            }

//            ServiceInstance inte = loadBalancerClient.choose("inte");
//            StringBuilder sb = new StringBuilder();
//            try {
//            sb.append("http://")
//                    .append(inte.getHost())
//                    .append(":")
//                    .append(inte.getPort())
//                    .append("/work?username=")
//                    .append(user.getUsername());
//                String number = restTemplate.getForObject(String.valueOf(sb), String.class);
//                System.out.println(number);
//                user.setNumber(number);
//            } catch (Exception e){
//                System.err.println(e);
//                user.setNumber("network error");
//            }


//                URL httpUrl = new URL("http://localhost:8080/work?username=" + user.getUsername());
//                HttpURLConnection connection = (HttpURLConnection) httpUrl.openConnection();
//                StringBuilder content = new StringBuilder();
//                if (connection.getResponseCode() == 200) {
//                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                    String str = bufferedReader.readLine();
//                    if (str != null) {
//                        content.append(str);
//                    }
//                    bufferedReader.close();
//                    System.out.println(content.toString());
//                    user.setNumber(String.valueOf(content));
//                } else {
//                    System.err.println(connection.getResponseCode());
//                }
    //    }
//        while (it.hasNext()){
//            User user = it.next();
//            String name = user.getUsername();
//
//            // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
//            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//
//            // 参数
//            StringBuffer params = new StringBuffer();
//            // 字符数据最好encoding以下;这样一来，某些特殊字符才能传过去(如:某人的名字就是“&”,不encoding的话,传不过去)
//            params.append("username=" + name);
//
//            // 创建Get请求
//            HttpGet httpGet = new HttpGet("http://localhost:8080/work" + "?" + params);
//            // 响应模型
//            CloseableHttpResponse response = null;
//            try {
//                // 由客户端执行(发送)Get请求
//                response = httpClient.execute(httpGet);
//
//                // 从响应模型中获取响应实体
//                HttpEntity responseEntity = response.getEntity();
//                System.out.println("响应状态为:" + response.getStatusLine());
//                if (responseEntity != null) {
//                    System.out.println("响应内容长度为:" + responseEntity.getContentLength());
//                    System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
//                    System.out.println(user.getUsername());
//                    System.out.println(EntityUtils.toString(responseEntity));
//                    //user.setNumber(Integer.valueOf(EntityUtils.toString(responseEntity)));
//                }
//            } catch (ParseException | IOException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    // 释放资源
//                    if (httpClient != null) {
//                        httpClient.close();
//                    }
//                    if (response != null) {
//                        response.close();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        if (users.size() == 0) {
            model.addAttribute("userList", users);
            model.addAttribute("message", "没有查询到数据");
        } else {
            model.addAttribute("userList", users);
        }
        return "list";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id, HttpSession httpSession) {
        Object username = httpSession.getAttribute("username");
        if (username == null) {
            return "请勿直接访问";
        }
        if (username != "admin"){
            return "非管理员用户，无删除权限";
        }
        userService.delete(id);
        Map<String, String> map = new HashMap<>();
        map.put("aaa", "bbb");
        String s = JSON.toJSONString(map);
        System.out.println(s);
        return s;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("username");
        return "login";
    }

    @PostMapping("/save")
    public String save(User user, HttpSession httpSession){
        Object username = httpSession.getAttribute("username");
        if (username == null) {
            return "请勿直接访问";
        }
        if (username != "admin"){
            return "非管理员用户，无存储权限";
        }
        Boolean result= userService.save(user);
        if(result){
            return "保存成功";
        }else{
            return "保存失败";
        }
    }
}
