package com.example.demo.service;

import com.example.demo.bean.Student;

/**
 * @Author zsp
 * @Date 2021/5/27 14:07
 * @Version 1.0
 */
public interface StudentService {

    /**
     * 根据sno查询
     */
    public Student queryFindBySno(String sno);
}
