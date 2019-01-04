package com.imooc.onetomany;

import org.apache.ibatis.session.SqlSession;

import com.imooc.untils.MyBatisUntil;

public class MainClass {

	public static void main(String[] args) {
		SqlSession sqlSession = null;

		sqlSession = MyBatisUntil.getSqlSession();
		ClassMapper dao = sqlSession.getMapper(ClassMapper.class);
		 System.out.println(dao);
		System.out.println(dao.selectClass(2));

		sqlSession.commit();
		sqlSession.close();

	}

}
