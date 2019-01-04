package com.example.demo.beanMapper;

import org.apache.ibatis.annotations.Select;

import com.example.demo.bean.SpringBoot01;

public interface SpringBoot01Mapper {
	
	@Select("select id,name from SpringBoot01 where id = #{id}")
	public SpringBoot01 getDemo(int id);
	
	
	

}
