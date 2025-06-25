package com.shinhan.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */

@Controller   //@Controller + Controller�� ����(request,response�� ����Ͽ� �����(spring�� ���� FrontController)�� ����)
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * @WebServlet("/") ===> spring������ @RequestMapping("/")
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home2(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		//request.setAttribute("serverTime", formattedDate)
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("myname", "jin" );
		
		return "home";   //���λ� : "home" + ���̻� 
	                           ///WEB-INF/views/home.jsp �������� forward �ȴ�.                            
	}
	
}
