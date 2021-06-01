package com.example.demo.service;

import com.example.demo.bean.Student;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * @Author zsp
 * @Date 2021/5/27 14:07
 * @Version 1.0
 */
@CacheConfig(cacheNames = "student")
public interface StudentService {

    /**
     * 根据sno查询
     */
    @Cacheable(key = "#p0")
    public Student queryFindBySno(String sno);

    @CachePut(key = "#p0")
    int insert(Student student);

    @CacheEvict(key = "#p0",allEntries = true)
    int deleteBySno(String sno);

    @CacheEvict(key = "#p0.sno")
    int update(Student student);
}
