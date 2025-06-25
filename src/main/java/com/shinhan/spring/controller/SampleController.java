package com.shinhan.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shinhan.spring.model.dept.DeptService;

//요청주소 연습

@Controller
@RequestMapping("/section02")  //class(type) level에서 주소지정
public class SampleController {

	@Autowired
	DeptService deptService;  //Spring이 new해서 Injection한다. 
 
	@RequestMapping(value = "/sample7.do", 
			params = {"userid=a", "userpass", "!email"})
	public @ResponseBody  String call(  ) {  
		 
		 return  "hello~~";
	}
//@ResponseBody : 응답문서에 data를 보낸다 .
//	@ResponseBody가 없으면 jsp페이지로 forward가 default이다. 
//HTTP 상태 400 – 잘못된 요청
//요청의 형식이 맞지않음 
	
	
	@GetMapping({"/sample5.do", "/sample6.do"})
	public ModelAndView f5(  ) {  //Model는 JSP페이지와 소통 Map<String,Object>
		ModelAndView mv = new ModelAndView(); 
		mv.addObject("subject", "스프링프레임워크");
		mv.addObject("day", 30);
		mv.addObject("dept", deptService.selectById(60));
		mv.addObject("deptlist", deptService.selectAll());
		mv.setViewName("section02/sample1");
		 return  mv;
	}
	
	@RequestMapping("/sample4.do")
	public ModelAndView f4(  ) {  //Model는 JSP페이지와 소통 Map<String,Object>
		ModelAndView mv = new ModelAndView(); 
		mv.addObject("subject", "스프링프레임워크");
		mv.addObject("day", 30);
		mv.addObject("dept", deptService.selectById(60));
		mv.addObject("deptlist", deptService.selectAll());
		mv.setViewName("section02/sample1");
		 return  mv;
	}
	
	
	
	@RequestMapping(value = "/sample3.do" , method = RequestMethod.GET)
	public ModelAndView f3(  ) {  //Model는 JSP페이지와 소통 Map<String,Object>
		ModelAndView mv = new ModelAndView(); 
		mv.addObject("subject", "스프링프레임워크");
		mv.addObject("day", 30);
		mv.addObject("dept", deptService.selectById(60));
		mv.addObject("deptlist", deptService.selectAll());
		mv.setViewName("section02/sample1");
		 return  mv;
	}
	
	
	
	//함수level에서 path지정 
	@RequestMapping(value = "/sample2.do" , method = RequestMethod.GET)
	public String f2( Model model) {  //Model는 JSP페이지와 소통 Map<String,Object>
		 model.addAttribute("subject", "스프링프레임워크");
		 model.addAttribute("day", 30);
		 model.addAttribute("dept", deptService.selectById(60));
		 model.addAttribute("deptlist", deptService.selectAll());
		 return "section02/sample1";  //접두사(/WEB-INF/views/) + view이름 + 접미사(.jsp)
	}
	
	@RequestMapping(value = "/sample1.do" , method = RequestMethod.GET)
	public void f1( Model model) {  //Model는 JSP페이지와 소통 Map<String,Object>
		 model.addAttribute("subject", "스프링프레임워크");
		 model.addAttribute("day", 30);
		 model.addAttribute("dept", deptService.selectById(60));
		 model.addAttribute("deptlist", deptService.selectAll());
	}
}







