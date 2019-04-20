package com.imooc.entity;

import java.util.List;

public class Persion {
	
	private String username;
	private String password;
	private int age;
	private Address address;
	private List<Persion> friends;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Persion> getFriends() {
		return friends;
	}
	public void setFriends(List<Persion> friends) {
		this.friends = friends;
	}
	public Persion() {
	}
	public Persion(String username, String password, int age, Address address, List<Persion> friends) {
		this.username = username;
		this.password = password;
		this.age = age;
		this.address = address;
		this.friends = friends;
	}
	

}
