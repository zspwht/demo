package com.example.demo.task;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 *
 */

@Component
public class TaskExecutorExample {
    @Data
    private class MessagePrintTask implements Runnable{
        private String message;

        public MessagePrintTask(String message){
            this.message = message;
        }
        @Override
        public void run() {
            System.out.println(message);
        }
    }
    @Resource(name = "taskExecutor")
    private TaskExecutor taskExecutor;

    public void printMessage(){

        for (int i = 0; i < 25; i++) {
            taskExecutor.execute(new MessagePrintTask("Message"+i));
        }

    }


}
