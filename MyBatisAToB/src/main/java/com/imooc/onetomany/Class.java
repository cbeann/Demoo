package com.imooc.onetomany;

import java.util.ArrayList;
import java.util.List;

public class Class {

	private Integer cid;

	private String cname;

	// 多方集合，即学生集合
	private List<Student> students = new ArrayList<>();

	@Override
	public String toString() {
		return "Class [cid=" + cid + ", cname=" + cname + ", students=" + students + "]";
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Class() {
	}

}
