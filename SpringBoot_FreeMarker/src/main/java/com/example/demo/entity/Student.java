package com.example.demo.entity;

public class Student {
	private int id;
	private String name;
	private int sex;

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Student(int id, String name, int sex) {
		this.id = id;
		this.name = name;
		this.sex = sex;
	}

	public Student() {
	}

}
