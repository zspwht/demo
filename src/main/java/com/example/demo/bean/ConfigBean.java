package com.example.demo.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author zsp
 * @Date 2021/5/27 9:45
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "mrbind.blog")
@Data
public class ConfigBean {
    private String name;
    private String title;
    private String wholeTitle;
}
