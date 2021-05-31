package com.example.demo.mapper.first;

import com.example.demo.bean.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * @Author zsp
 * @Date 2021/5/31 14:45
 * @Version 1.0
 */
@Repository
public interface SySLogMapper {
    @Insert("insert into sys_log(userName,operation,time,method,params,ip,createTime,updateTime)" +
            "values (#{userName},#{operation},#{time},#{method},#{params},#{ip},#{createTime},#{updateTime})")
    int insert(SysLog sysLog);
}
