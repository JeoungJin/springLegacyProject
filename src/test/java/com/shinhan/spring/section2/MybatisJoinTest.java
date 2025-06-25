package com.shinhan.spring.section2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.shinhan.spring.model.emp.EmpDAOMybatisJoin;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { 
		"file:src/main/webapp/WEB-INF/spring/root-context-oracle.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context-tx.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context-no.xml" })

public class MybatisJoinTest {
	
	@Autowired
	EmpDAOMybatisJoin joinRepo;
	
	//@Test
	void f1() {
		joinRepo.selectAllJoinFlat().forEach(e->System.out.println(e));
	}
	@Test
	void f2() {
		joinRepo.selectAllJoinAsso().forEach(e->System.out.println(e));
	}

}
