package com.shinhan.spring.model.account;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOMybatis {
	@Autowired
	SqlSession sqlSession;
	
	String namespace = "com.firstzone.account";

	public void update1()  {
		sqlSession.update(namespace + ".update1");
	}

	public void update2()  {
		sqlSession.update(namespace + ".update2");
	}
}
