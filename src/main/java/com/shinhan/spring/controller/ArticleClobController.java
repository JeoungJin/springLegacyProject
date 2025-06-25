package com.shinhan.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shinhan.spring.model.clob.ArticleDTO;
import com.shinhan.spring.model.clob.ArticleService;
import com.shinhan.spring.model.except.PasswordException;

@RestController
@RequestMapping("/article")
public class ArticleClobController {

	@Autowired
	ArticleService articleService;
	
	@GetMapping("selectAll.do")
	public List<ArticleDTO> selectAll() {
		List<ArticleDTO> alist = null;
	 
		alist = articleService.selectAll2();
		return alist;
	}
	
	@GetMapping("selectby.do/{title}/{content}")
	public List<ArticleDTO> select(@PathVariable String title, @PathVariable String content) {
		List<ArticleDTO> alist = null;
	 
		alist = articleService.selectByCondition(title, content);
		return alist;
	}
	
	
	@PostMapping("/insert.do")
	public String insert(@RequestBody  ArticleDTO articleDTO) {
		int result = articleService.insert(articleDTO);
		return result>0?"insert success":"insert fail";
	}
}
