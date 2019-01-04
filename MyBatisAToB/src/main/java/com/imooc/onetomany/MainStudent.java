package com.imooc.onetomany;

import org.apache.ibatis.session.SqlSession;

import com.imooc.untils.MyBatisUntil;


public class MainStudent {

	public static void main(String[] args) {
		SqlSession sqlSession = null;
		
		sqlSession = MyBatisUntil.getSqlSession();
		StudentMapper dao=sqlSession.getMapper(StudentMapper.class);
		//System.out.println(dao);
		System.out.println(dao.selectStudent(1));
		
		sqlSession.commit();
		sqlSession.close();

	}

}
