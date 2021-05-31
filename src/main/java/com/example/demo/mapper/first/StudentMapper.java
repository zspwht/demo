package com.example.demo.mapper.first;

import com.example.demo.bean.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zsp
 * @Date 2021/5/27 13:59
 * @Version 1.0
 */

@Repository
@Mapper
public interface StudentMapper {

    @Insert("insert into student (sno,sname,ssex) values(#{sno},#{sname},#{ssex})")
    int insert(Student student);

    @Update("update student set sname=#{sname},ssex=#{ssex} where sno = #{sno}")
    int update(Student student);

    @Delete("delete from student where sno = #{sno}")
    int delete(String sno);

    @Select("select sno,sname,ssex from student")
    List<Student> queryAll();

    @Select("select sno,sname,ssex from student where sno =#{sno}")
    Student queryBySno(String sno);
}
