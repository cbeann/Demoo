package com.example.demo;

public class UserType {

	private Integer id;

	private String name;

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
		this.name = name == null ? null : name.trim();
	}

	@Override
	public String toString() {
		return "UserType [id=" + id + ", name=" + name + "]";
	}

	public UserType(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public UserType() {
	}

}
