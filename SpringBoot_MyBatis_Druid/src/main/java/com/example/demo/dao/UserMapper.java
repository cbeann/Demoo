package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.User;
@Mapper
public interface UserMapper {
	
	public User selectByPrimaryKey(Integer id);

}
