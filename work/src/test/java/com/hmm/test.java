package com.hmm;

import com.hmm.entity.User;
import com.hmm.service.userServiceImpl;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @Author hmm
 * @Date 2021/9/24 10:21
 */
public class test {

    @Autowired
    userServiceImpl userService;


    @Test
    public void test01() {
        URL httpUrl = null;
        try {
            httpUrl = new URL("http://localhost:8080/work?username=admin");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) httpUrl.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder content = new StringBuilder();
        try {
            if (connection.getResponseCode() == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String str;
                while ((str = bufferedReader.readLine()) != null) {
                    content.append(str);
                }
                bufferedReader.close();
                System.out.println(content.toString());
            } else {
                System.err.println(connection.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02() {
        try {
            URL url = new URL("http://127.0.0.1:8080/work?username=admin");
            System.out.println("URL 为：" + url.toString());
            System.out.println("协议为：" + url.getProtocol());
            System.out.println("验证信息：" + url.getAuthority());
            System.out.println("文件名及请求参数：" + url.getFile());
            System.out.println("主机名：" + url.getHost());
            System.out.println("路径：" + url.getPath());
            System.out.println("端口：" + url.getPort());
            System.out.println("默认端口：" + url.getDefaultPort());
            System.out.println("请求参数：" + url.getQuery());
            System.out.println("定位位置：" + url.getRef());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test03() {
        try {
            URL httpUrl = new URL("http://localhost:8080/work?username=admin");
            HttpURLConnection connection = (HttpURLConnection) httpUrl.openConnection();
            StringBuilder content = new StringBuilder();
            if (connection.getResponseCode() == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String str = bufferedReader.readLine();
                //System.out.println("str1" + str);
                while (str != null) {
                    //System.out.println("str2" + str);
                    content.append(str);
                    //System.out.println("content" + content);
                }
                bufferedReader.close();
                //System.out.println(content);
                System.out.println(content.toString());
            } else {
                System.err.println(connection.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test04() {
        userService.query();
        //System.out.println(users);
    }
}
