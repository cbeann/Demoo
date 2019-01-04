package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.serivce.Service;

@Controller
public class HelloHandler {
	
	
	@Autowired
	private Service servcie;
	
	
	@RequestMapping("/method1")
	@ResponseBody
	public String method1(){
		
		return servcie.getDemo(1).toString();
		//return "123";
	}
	
	
	@RequestMapping("/method2")
	public String method2(Map<String,Object> map){
		map.put("username", "张三");
		return "index";
	}


	public Service getServcie() {
		return servcie;
	}


	public void setServcie(Service servcie) {
		this.servcie = servcie;
	}
	
	
	

}
