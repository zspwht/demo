package com.example.demo.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author zsp
 * @Date 2021/5/27 9:52
 * @Version 1.0
 */
@Component
@Data
public class BlogProperties {
    @Value("${mrbind.blog.name}")
    private String name;
    @Value("${mrbind.blog.title}")
    private String title;
}
