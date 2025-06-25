package com.shinhan.spring.model.clob;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleInterface {
	public List<ArticleDTO> selectAll() ;
	public List<ArticleDTO> selectByCondition(@Param("title") String title, @Param("content") String content);
	
	
	public int insert(ArticleDTO article) ;
	
}


