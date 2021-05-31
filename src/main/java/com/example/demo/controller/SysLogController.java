package com.example.demo.controller;

import com.example.demo.annotation.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zsp
 * @Date 2021/5/31 15:20
 * @Version 1.0
 */
@RestController
@RequestMapping("syslog")
public class SysLogController {

    @Log("执行方法一")
    @RequestMapping("one")
    public void methodOne(){}


    @Log("执行方法二")
    @RequestMapping("two")
    public void methodTwo(String name){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Log("执行方法三")
    @RequestMapping("three")
    public void methodThres(String name,String age){}
}
