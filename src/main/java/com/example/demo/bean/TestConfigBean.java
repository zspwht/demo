package com.example.demo.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author zsp
 * @Date 2021/5/27 9:45
 * @Version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "test")
@PropertySource("classpath:application-test.yml")
@Data
public class TestConfigBean {
    private String name;
    private String age;
}
