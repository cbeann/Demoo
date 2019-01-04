package com.imooc.manytoone;

import org.apache.ibatis.session.SqlSession;

import com.imooc.untils.MyBatisUntil;

public class MainCity {

	public static void main(String[] args) {
		SqlSession sqlSession = null;

		sqlSession = MyBatisUntil.getSqlSession();
		CityMapper dao = sqlSession.getMapper(CityMapper.class);
		 System.out.println(dao);
		System.out.println(dao.selectCity(2));

		sqlSession.commit();
		sqlSession.close();

	}

}
