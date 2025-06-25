package com.shinhan.spring.model.clob;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinhan.spring.model.except.ExceptionMessage;
import com.shinhan.spring.model.except.PasswordException;

import lombok.RequiredArgsConstructor;

@Service
public class ArticleService {

	@Autowired
	ArticleInterface interfaceMapper;

	public List<ArticleDTO> selectAll2() {
		return interfaceMapper.selectAll();
	}
	
	public List<ArticleDTO> selectByCondition(String title, String content) {
		return interfaceMapper.selectByCondition(title, content);
	}
	
	

	@Autowired
	ArticleDAOMybatis dao;

	public List<ArticleDTO> selectAll() {

		return dao.selectAll();
	}

	public int insert(ArticleDTO article) {
		return dao.insert(article);
	}

}
