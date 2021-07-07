package com.example.demo.bean;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @Author zsp
 * @Date 2021/5/6 10:19
 * @Version 1.0
 */
@Data
public class User {
    /*private Long id;
    private String name;*/

    private Integer id;
    private String userName;
    private String password;
    private Date createTime;
    private Date updateTime;
    private Integer status;
}
