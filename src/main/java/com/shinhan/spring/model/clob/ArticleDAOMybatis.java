package com.shinhan.spring.model.clob;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleDAOMybatis {
	@Autowired
	SqlSession sqlSession;
	
	String namespace = "com.firstzone.article";

	 
	public List<ArticleDTO> selectAll()  {
		return sqlSession.selectList(namespace + ".selectAll");
	}
	
	public int insert(ArticleDTO article)  {
		return sqlSession.insert(namespace + ".insert", article);
	}
	
	
}
