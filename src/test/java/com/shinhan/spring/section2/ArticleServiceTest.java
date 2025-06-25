package com.shinhan.spring.section2;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.shinhan.spring.model.clob.ArticleDTO;
import com.shinhan.spring.model.clob.ArticleService;

//����test
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { 
		"file:src/main/webapp/WEB-INF/spring/root-context-oracle.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context-tx.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context-no.xml" } )
 
public class ArticleServiceTest {
	@Autowired
	ArticleService articleService;
	 
	@Test
	void selectAll() {
		List<ArticleDTO> list = articleService.selectAll2();
		System.out.println("�Ǽ�:" + list.size());
		list.forEach(article->System.out.println(article)); 
	}
	
	//@Test
	void insert() {
		ArticleDTO article = ArticleDTO.builder()
				.title("article����2")
				.content("2���� ū ���ڿ��� �����մϴ�.")
				.build();
		articleService.insert(article);
	}
	
	
}

	 




