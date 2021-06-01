package com.example.demo;

import com.example.demo.bean.Student;
import com.example.demo.bean.User;
import com.example.demo.mapper.first.StudentMapper;
import com.example.demo.mapper.second.UserMapper;
import com.example.demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private StudentMapper studentMapper;


	@Autowired
	StudentService studentService;
	@Autowired
	private UserMapper userMapper;
	@Test
	void contextLoads() {

	}
	@Test
	public void test(){
		/*Student student = new Student();
		student.setSno("004");
		student.setSname("xiaoming");
		student.setSsex("M");*/
		//studentMapper.delete("004");
		/*List<Student> students = studentMapper.queryAll();
		students.stream().filter(student -> student.getSno().equals("004")).forEach(System.out::println);*/
		/*User user = new User();
		user.setId(3l);
		user.setName("xiaoli");
		userMapper.insert(user);*/

		Student student1 = studentService.queryFindBySno("009");
		System.out.println("学号" + student1.getSno() + "的学生姓名为：" + student1.getSname());
/*
		Student student2 = studentService.queryFindBySno("001");
		System.out.println("学号" + student2.getSno() + "的学生姓名为：" + student2.getSname());*/
		/*Student student = new Student();
		student.setSsex("F");
		student.setSname("ssss");
		student.setSno("009");
		studentService.insert(student);*/
	}
}
