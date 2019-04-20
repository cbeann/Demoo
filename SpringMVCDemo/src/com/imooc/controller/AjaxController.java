package com.imooc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.entity.Student;

@Controller
public class AjaxController {

	

	@RequestMapping(value = "/ajaxStr.action", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String method1(HttpServletRequest request) {
		// 获得key为username的value
		String username = request.getParameter("username");
		// 处理获得的参数
		System.out.println(username);
		String reslut = "登录成功:" + username;
		// 返回结果
		return reslut;
	}

	@RequestMapping(value = "/ajaxList.action",  produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public List<Student> returnList(HttpServletRequest request) {
		System.out.println("从前台获取的参数：" + request.getParameter("username"));

		List<Student> students = new ArrayList<>();
		Student stu1 = new Student(1, "张三");
		Student stu2 = new Student(2, "李四");
		Student stu3 = new Student(3, "王五");
		students.add(stu1);
		students.add(stu2);
		students.add(stu3);
		return students;

	}

	@RequestMapping(value = "/ajaxMap.action",  produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public Map<String, Object> returnMap() {
		Map<String, Object> maps = new HashMap<>();
		
		maps.put("student", "张三");
		maps.put("teacher", "李四");

		return maps;
	}
	
	
	
	
	
	

}
