package com.imooc.entity;

public class Address {
	private String first;
	private String second;
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getSecond() {
		return second;
	}
	public void setSecond(String second) {
		this.second = second;
	}
	public Address(String first, String second) {
		super();
		this.first = first;
		this.second = second;
	}
	public Address() {
	}
	

}
