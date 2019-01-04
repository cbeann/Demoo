package com.example.demo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserTypeMapper {
	
	
	public UserType selectById(Integer id);

}
