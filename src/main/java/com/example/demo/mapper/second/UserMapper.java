package com.example.demo.mapper.second;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author zsp
 * @Date 2021/5/27 16:00
 * @Version 1.0
 */
@Repository
@Mapper
public interface UserMapper {
    int insert(User user);
}
