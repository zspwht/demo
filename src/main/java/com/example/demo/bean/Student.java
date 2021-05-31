package com.example.demo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author zsp
 * @Date 2021/5/27 13:48
 * @Version 1.0
 */
@Data
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String sno;
    private String sname;
    private String ssex;
}
