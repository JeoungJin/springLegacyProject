package com.shinhan.spring.section2;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shinhan.spring.model.emp.EmpRequestDTO;

import lombok.extern.slf4j.Slf4j;

//SpringBoot는 @SpringBootTest
@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = 
    { "file:src/main/webapp/WEB-INF/spring/root-context-oracle.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context-tx.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context-no.xml" })
@WebAppConfiguration 
//Spring MVC 환경에서 웹 애플리케이션 컨텍스트(WebApplicationContext) 를 로딩하도록 지정
public class EmpControllerTest {

	//Spring MVC에서 사용되는 웹 애플리케이션 컨텍스트 객체
	@Autowired
	private WebApplicationContext wac;
	//이 객체를 통해 GET, POST 등의 HTTP 요청을 테스트
	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
  //요청과 응답 정보를 콘솔에 출력하는 용도로 사용
	//andDo(MockMvcResultHandlers.print())
	@Test
	void testSelectAll() throws Exception {
	    mockMvc.perform(MockMvcRequestBuilders.get("/emp/emplist.do"))
	        .andDo(MockMvcResultHandlers.print())
	        .andExpect(status().isOk())
	        .andExpect(view().name("emp/empAll"))
	        .andExpect(model().attributeExists("joblist"))
	        .andExpect(model().attributeExists("deptlist"));
	}
	
	 
    @DisplayName("조건조회")
	@Test
	void testSelectByCondition2() throws Exception {
	    // 테스트에 사용할 요청 DTO
	    EmpRequestDTO dto = new EmpRequestDTO();
	    dto.setDeptid(new Integer[]{60, 20});
	    dto.setJobid("IT_PROG");
	    dto.setSalary(3000);
	    dto.setHire_date("2025-06-05");
	    dto.setDate_check("true");

	    // JSON 변환
	    String json = new ObjectMapper().writeValueAsString(dto);
	    mockMvc.perform(MockMvcRequestBuilders.post("/emp/selectByCondition2.do")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(json))
	        .andDo(MockMvcResultHandlers.print())
	        .andExpect(status().isOk())
	        .andExpect(view().name("emp/empByCondition"))
	        .andExpect(model().attributeExists("emplist"));  
	}
	
	@DisplayName("상세보기")
	@Test
	void testGetEmpDetail() throws Exception {
	    mockMvc.perform(MockMvcRequestBuilders.get("/emp/empdetail.do")
	            .param("empid2", "100"))
	        .andDo(MockMvcResultHandlers.print())
	        .andExpect(status().isOk())
	        .andExpect(model().attributeExists("joblist"))
	        .andExpect(model().attributeExists("deptlist"))
	        .andExpect(model().attributeExists("emp"));
	}
	
	@Test
	void testEmpUpdateRedirect() throws Exception {
	    mockMvc.perform(MockMvcRequestBuilders.post("/emp/empdetail.do")
	            .param("employee_id", "100")
	            .param("first_name", "Steven2")
	            .param("last_name", "King2")
	            .param("email", "steven.king@company.com")
	            .param("job_id", "IT_PROG")
	            .param("hire_date", "2025-01-01")
	            .param("salary", "6000"))
	        .andDo(MockMvcResultHandlers.print())
	        .andExpect(status().is3xxRedirection())
	        .andExpect(redirectedUrl("emplist.do"))
	        .andExpect(flash().attributeExists("resultMessage"));
	}
}


