package com.imooc.manytoone;

import org.apache.ibatis.session.SqlSession;

import com.imooc.untils.MyBatisUntil;

public class MainCountry {

	public static void main(String[] args) {
		SqlSession sqlSession = null;

		sqlSession = MyBatisUntil.getSqlSession();
		CountryMapper dao = sqlSession.getMapper(CountryMapper.class);
		 System.out.println(dao);
		System.out.println(dao.selectCountry(2));

		sqlSession.commit();
		sqlSession.close();

	}

}
