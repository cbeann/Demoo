package com.example.demo.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;

@Controller
public class HelloHandler {
	
	
	@Autowired
	private UserMapper  userMapper;
	
	
	
	@RequestMapping("/selectUser.action")
	public String selectUser(int id,Map<String,Object> map){
		User user=userMapper.selectByPrimaryKey(id);
		map.put("user", user);
		return "/success";
	}

}
