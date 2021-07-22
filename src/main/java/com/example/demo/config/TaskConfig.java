package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class TaskConfig {

    @Bean
    public TaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(5);  //线程池大小
        threadPoolTaskExecutor.setMaxPoolSize(10);  //最大线程池数
        threadPoolTaskExecutor.setQueueCapacity(25);  //队列中的容量
        return threadPoolTaskExecutor;
    }
}
