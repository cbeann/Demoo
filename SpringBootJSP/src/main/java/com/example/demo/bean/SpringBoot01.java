package com.example.demo.bean;

public class SpringBoot01 {
	
	private Integer id;
	
	private String name;
	
	

	public SpringBoot01() {
		
	}

	public SpringBoot01(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "SpringBoot01 [id=" + id + ", name=" + name + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
