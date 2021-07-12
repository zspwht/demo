package com.example.demo.mapper.first;

import com.example.demo.bean.Role;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zsp
 * @Date 2021/7/8 10:05
 * @Version 1.0
 */
@Repository
public interface UserRoleMapper {
    List<Role> findByUserName(String userName);
}
