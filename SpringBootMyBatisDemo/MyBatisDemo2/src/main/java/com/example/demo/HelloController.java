package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@Autowired
	private UserTypeMapper userTypeMapper;
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello(){
		System.out.println(userTypeMapper);
		System.out.println(userTypeMapper.selectById(1));
		return "hello";
	}

}
