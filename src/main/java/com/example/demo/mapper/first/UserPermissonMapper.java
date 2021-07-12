package com.example.demo.mapper.first;

import com.example.demo.bean.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zsp
 * @Date 2021/7/8 10:03
 * @Version 1.0
 */
@Repository
public interface UserPermissonMapper {
    List<Permission> findByUserName(String userName);
}
