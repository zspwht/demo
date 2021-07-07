package com.example.demo.mapper.first;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author zsp
 * @Date 2021/6/2 15:35
 * @Version 1.0
 */
@Repository
public interface UserMapper {
    User findByUserName(String userName);
}
