package com.shinhan.spring.section2;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.shinhan.spring.model.emp.EmpDTO;
import com.shinhan.spring.model.emp.EmpService;
import com.shinhan.spring.util.DateUtil;

//통합test
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { 
		"file:src/main/webapp/WEB-INF/spring/root-context-oracle.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context-tx.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context-no.xml" })
public class EmpServiceTestIntegration {
	@Autowired
	EmpService empService;

	@Test
	@DisplayName("직원번호로 조회")
	void testFindById() {
		EmpDTO emp = empService.selectById(100);
		assertNotNull(emp);
		assertEquals("Steven", emp.getFirst_name());
	}

	@DisplayName("직원모두조회")
	@Test
	void testFindAll() {
		List<EmpDTO> list = empService.selectAll();
		assertNotNull(list);
		assertTrue(list.size() > 0);
		//assertEquals(105, list.size());
	}

	@Disabled
	@DisplayName("직원입력")
	@Test
	void testInsert() {
		int empid = 35;
		EmpDTO newEmp = EmpDTO.builder()
				.employee_id(empid)
				.first_name("jin35")
				.last_name("j")
				.hire_date(DateUtil.convertToSQLDate("2025-01-01"))
				.job_id("IT_PROG")
				.email("web040635@daum.net")
				.build();
		empService.empInsert(newEmp);
		EmpDTO result = empService.selectById(empid);
		assertNotNull(result);
		assertEquals("jin35", result.getFirst_name());
	}
	
	
	@Disabled
	@DisplayName("직원수정")
	@Test
	void testUpdate() {
		int empid = 34;
		EmpDTO emp = EmpDTO.builder()
				.employee_id(empid)
				.first_name("jin34")
				.last_name("j2")
				.hire_date(DateUtil.convertToSQLDate("2025-01-01")).job_id("IT_PROG").email("web0406AA@daum.net")
				.build();
		empService.empUpdate(emp);
		EmpDTO result = empService.selectById(empid);
		assertEquals("jin34", result.getFirst_name());
	}

	
	@Disabled
	@Test
	void testDelete() {
		int empid = 34;
		empService.empDeleteById(empid);
		EmpDTO result = empService.selectById(empid);
		assertNull(result);
	}
}




