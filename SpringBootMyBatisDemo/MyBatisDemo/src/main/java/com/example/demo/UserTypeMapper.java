package com.example.demo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserTypeMapper {
	
	@Select("select id,name from userType where id = #{id}")
	public UserType selectById(Integer id);

}
