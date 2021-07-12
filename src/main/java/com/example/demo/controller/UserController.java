package com.example.demo.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author zsp
 * @Date 2021/7/8 11:42
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

//    @RequiresPermissions("user:user")
    @RequestMapping("list")
    public String userList(Model model){
        model.addAttribute("value","获取用户信息");
        return "user";
    }

//    @RequiresPermissions("user:add")
    @RequestMapping("add")
    public String userAdd(Model model){
        model.addAttribute("value","新增用户信息");
        return "user";
    }

//    @RequiresPermissions("user:delete")
    @RequestMapping("delete")
    public String userDelete(Model model){
        model.addAttribute("value","删除用户信息");
        return "user";
    }
}
