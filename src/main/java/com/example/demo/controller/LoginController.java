package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.utils.MD5Utils;
import com.example.demo.vo.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.omg.CORBA.portable.UnknownException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.internal.AuthorizationDataEntry;

import javax.jws.WebParam;

/**
 * @Author zsp
 * @Date 2021/6/30 16:01
 * @Version 1.0
 */
@Controller
public class LoginController {


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Result login(String userName,String password,boolean rememberMe){
        password = MD5Utils.encrypt(userName,password);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName,password,rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
            return Result.ok();
        }catch (UnknownException e){
            return Result.error(e.getMessage());
        }catch (IncorrectCredentialsException e){
            return Result.error(e.getMessage());
        }catch (LockedAccountException e){
            return Result.error(e.getMessage());
        }catch (AuthorizationException e){
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping("/")
    public String redirctIndex(){
        return "redirect:/index";
    }


    @RequestMapping("/index")
    public String index(Model model){
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user",user);
        return "index";
    }

    @GetMapping("/403")
    public String forbid(){
        return "403";
    }
}
