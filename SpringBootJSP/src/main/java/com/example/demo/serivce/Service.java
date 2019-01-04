package com.example.demo.serivce;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.bean.SpringBoot01;
import com.example.demo.beanMapper.SpringBoot01Mapper;

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	private SpringBoot01Mapper dao;
	
	
	public SpringBoot01 getDemo(int id){
		return dao.getDemo(id);
	}

	public Service() {
		
	}

	public SpringBoot01Mapper getDao() {
		return dao;
	}

	public void setDao(SpringBoot01Mapper dao) {
		this.dao = dao;
	}
	
	

}
