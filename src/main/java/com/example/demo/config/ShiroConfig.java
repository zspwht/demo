package com.example.demo.config;

import com.example.demo.shiro.ShiroRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @Author zsp
 * @Date 2021/6/30 15:34
 * @Version 1.0
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        LinkedHashMap<String,String> filterChainDefination = new LinkedHashMap<>();
        filterChainDefination.put("/css/**","anon");
        filterChainDefination.put("/js/**","anon");
        filterChainDefination.put("/fonts/**","anon");
        filterChainDefination.put("/img/**","anon");
        filterChainDefination.put("/druid/**","anon");
        filterChainDefination.put("/logout/**","logout");
        filterChainDefination.put("/","anon");
        filterChainDefination.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefination);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        return securityManager;
    }

    @Bean
    public ShiroRealm shiroRealm(){
        ShiroRealm shiroRealm = new ShiroRealm();
        return shiroRealm;
    }
}
