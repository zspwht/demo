package com.example.demo.controller;

import com.example.demo.bean.BlogProperties;
import com.example.demo.bean.ConfigBean;
import com.example.demo.bean.TestConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zsp
 * @Date 2021/5/27 9:45
 * @Version 1.0
 */
@RestController
public class IndexController {
    @Autowired
    private BlogProperties blogProperties;
    @Autowired
    private ConfigBean configBean;
    @Autowired
    private TestConfigBean testConfigBean;
   /* @RequestMapping("/")
    public String index(){
        return  testConfigBean.getName()+ "," +testConfigBean.getAge();
    }*/
}
