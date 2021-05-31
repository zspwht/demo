package com.example.demo.service.impl;

import com.example.demo.bean.Student;
import com.example.demo.mapper.first.StudentMapper;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zsp
 * @Date 2021/5/27 14:10
 * @Version 1.0
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Student queryFindBySno(String sno) {
        return this.studentMapper.queryBySno(sno);
    }
}
