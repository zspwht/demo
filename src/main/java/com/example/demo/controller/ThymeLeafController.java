package com.example.demo.controller;

import com.example.demo.bean.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zsp
 * @Date 2021/5/31 15:55
 * @Version 1.0
 */
@Controller
public class ThymeLeafController {
    @RequestMapping("account")
    public String account(Model model){
        List<Account> lists = new ArrayList<>();
        lists.add(new Account("KangKang", "康康", "e10adc3949ba59abbe56e", "超级管理员", "17777777777"));
        lists.add(new Account("Mike", "麦克", "e10adc3949ba59abbe56e", "管理员", "13444444444"));
        lists.add(new Account("Jane","简","e10adc3949ba59abbe56e","运维人员","18666666666"));
        lists.add(new Account("Maria", "玛利亚", "e10adc3949ba59abbe56e", "清算人员", "19999999999"));
        model.addAttribute("accountList",lists);
        return "account";
    }
}
