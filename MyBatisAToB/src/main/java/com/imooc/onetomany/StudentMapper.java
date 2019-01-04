package com.imooc.onetomany;

public interface StudentMapper {

	//根据ID查询学生
	public Student selectStudent(Integer id);

	//根据classID查询学生
	public Student selectStudentByClassId(Integer classID);

}
