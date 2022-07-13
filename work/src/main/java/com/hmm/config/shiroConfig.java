package com.hmm.config;

import com.hmm.realm.myRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class shiroConfig {

    // 散列算法
    private String hashAlgorithmName = "md5";
    // 迭代次数
    private Integer hashIterations = 1024;

    /**
     * 获取凭证匹配器
     *
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName(hashAlgorithmName);
        matcher.setHashIterations(hashIterations);
        return matcher;
    }

    /**
     * 获取自定义的Realm
     *
     * @return
     */
    @Bean
    public myRealm authcRealm(HashedCredentialsMatcher matcher) {
        myRealm realm = new myRealm();
        realm.setCredentialsMatcher(matcher);
        return realm;
    }

    /**
     * 获取SecurityManager对象
     *
     * @param realm
     * @return
     */
    @Bean
    public SecurityManager securityManager(myRealm realm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realm);
        return manager;
    }

    /**
     * 注册ShiroFilterFactoryBean
     *
     * @param manager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager manager) {
        ShiroFilterFactoryBean filter = new ShiroFilterFactoryBean();
        filter.setSecurityManager(manager);
        filter.setLoginUrl("/user/login");
        filter.setSuccessUrl("/success.html");
        filter.setUnauthorizedUrl("/refuse.html");


        // 设置过滤器链
        Map<String, String> map = new HashMap<>();
        map.put("/user/login", "anon");
        map.put("/user/query", "anon");
        map.put("/user/index", "anon");
        //map.put("/user/register","anon");
        //map.put("/**","authc");
        map.put("/**", "anon");
        filter.setFilterChainDefinitionMap(map);
        return filter;
    }
}

