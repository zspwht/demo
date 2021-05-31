package com.example.demo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author zsp
 * @Date 2021/5/31 15:48
 * @Version 1.0
 */
@Data
public class Account implements Serializable {
    public static final long serialVersionUID = 1L;

    private String account;
    private String name;
    private String password;
    private String accountType;
    private String tel;


    public Account(){}
    public Account(String account, String name, String password, String accountType, String tel) {
        super();
        this.account = account;
        this.name = name;
        this.password = password;
        this.accountType = accountType;
        this.tel = tel;
    }
}
