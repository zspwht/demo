package com.example.demo.bean;

import lombok.Data;
import org.springframework.context.annotation.DependsOn;

import java.util.Date;

/**
 * @Author zsp
 * @Date 2021/7/9 11:23
 * @Version 1.0
 */
@Data
public class UserOnline {

    private static final long seriaVersionUID = 1L;
    private String id;
    private String userId;
    private String userName;
    private String systemHost;
    private String status;
    private Date startTimestamp;
    private Date lastAcessTime;
    private Long timeout;
}
