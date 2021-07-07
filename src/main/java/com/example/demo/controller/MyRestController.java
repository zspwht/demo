package com.example.demo.controller;

import com.example.demo.bean.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zsp
 * @Date 2021/5/6 10:17
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/users")
public class MyRestController {
    @RequestMapping(value = "/{user}",method = RequestMethod.GET)
    public User getUser(@PathVariable Long user){
        return null;
    }
    @RequestMapping(value = "/{user11}",method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable Long user){
        return null;
    }
}
