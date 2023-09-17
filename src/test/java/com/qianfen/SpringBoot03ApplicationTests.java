package com.qianfen;

import com.qianfen.entity.Student;
import com.qianfen.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringBoot03ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Resource
	StudentMapper studentMapper;


	@Test
	public void findAllStudent(){
		List<Student> allStudent = studentMapper.findAllStudent();
		System.out.println("allStudent = " + allStudent);
	}
}
