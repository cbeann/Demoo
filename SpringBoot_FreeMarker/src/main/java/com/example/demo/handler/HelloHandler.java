package com.example.demo.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Student;

@Controller
public class HelloHandler {
	
	@RequestMapping("/hello")
	public String hello(Map<String,Object> map){
		System.out.println("init ");
		
		//int
		int intVar=1;
		map.put("intVar", intVar);
		
		//boolean
		Boolean booleanVar=true;
		map.put("booleanVar", booleanVar);
		
		//null就是不存在
		map.put("nullVar", null);
		
		//List and 自定义student
		List<Student> listVar=new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Student stu=new Student(i, "张三"+i, 1);
			listVar.add(stu);
		}
		Student stu=new Student(3, "李四", 2);
		listVar.add(stu);
		Student stu2=new Student(4, "王五", 3);
		listVar.add(stu2);
		map.put("listVar", listVar);
		
		//map
		Map<String,Object> mapVar=new HashMap<>();
		mapVar.put("张三", "123");
		mapVar.put("李四", "456");
		map.put("mapVar", mapVar);
		
		
		//switch Var
		int switchVar=65;
		map.put("switchVar", switchVar);
		
		//date
		map.put("dateVar", new Date());
		
		
		
		
		return "result";
	}

}
