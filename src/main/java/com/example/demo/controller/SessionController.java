package com.example.demo.controller;

import com.example.demo.bean.UserOnline;
import com.example.demo.service.SessionService;
import com.example.demo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author zsp
 * @Date 2021/7/9 11:26
 * @Version 1.0
 */
@Controller
@RequestMapping("online")
public class SessionController {

    @Autowired
    private SessionService sessionService;
    @RequestMapping("index")
    public String online(){
        return "online";
    }

    @RequestMapping("list")
    @ResponseBody
    public List<UserOnline> list(){
        return  sessionService.list();
    }

    @RequestMapping("forceLogout")
    @ResponseBody
    public Result forceLogOut(String id){
        try{
            sessionService.forceLogout(id);
            return  Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return  Result.error("踢出用户失败");
        }

    }
}
