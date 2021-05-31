package com.example.demo.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zsp
 * @Date 2021/5/31 14:27
 * @Version 1.0
 */
@Data
public class SysLog implements Serializable {
    public static final long serialVersionUID = 1L;

    private Integer id;
    private String userName;
    private String operation;
    private Integer time;
    private String method;
    private String params;
    private String ip;
    private Date createTime;
    private Date updateTime;
}
