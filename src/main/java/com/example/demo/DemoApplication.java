package com.example.demo;

import com.example.demo.bean.ConfigBean;
import com.example.demo.bean.TestConfigBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@SpringBootApplication
//@EnableConfigurationProperties({ConfigBean.class, TestConfigBean.class})
public class DemoApplication {
	/*@RequestMapping("/")
	public String index(){
		return "hello spring boot";
	}*/
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DemoApplication.class);
		app.setAddCommandLineProperties(false);
		app.run(args);
	}

}
