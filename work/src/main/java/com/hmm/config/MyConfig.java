package com.hmm.config;

import com.hmm.intercepter.MyIntercepter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author hmm
 * @Date 2021/9/23 14:20
 */
@Configuration
public class MyConfig extends WebMvcConfigurationSupport {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new MyIntercepter());
        registration.addPathPatterns("/**"); //所有路径都被拦截
        //registration.excludePathPatterns("/**");
        registration.excludePathPatterns("/user/login");//不被拦截的路径
        registration.excludePathPatterns("/user/register");
        registration.excludePathPatterns("/user/index");
        registration.excludePathPatterns("/templates/**");
//        registration.excludePathPatterns("/test");
    }
}
