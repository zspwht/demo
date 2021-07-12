package com.example.demo.service;

import com.example.demo.bean.UserOnline;

import java.util.List;

/**
 * @Author zsp
 * @Date 2021/7/9 11:30
 * @Version 1.0
 */
public interface SessionService {
    List<UserOnline> list();

    boolean forceLogout(String id);
}
