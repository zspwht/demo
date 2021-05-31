package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.example.demo.bean.User;
import com.example.demo.service.StudentService;
import com.example.demo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zsp
 * @Date 2021/5/27 14:12
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "findBySno",method = RequestMethod.POST)
    public Result<Student> searchStudent(@RequestParam(value = "sno",required = false) String sno){
        Student student = studentService.queryFindBySno(sno);
        return Result.ok(student);
    }
}
