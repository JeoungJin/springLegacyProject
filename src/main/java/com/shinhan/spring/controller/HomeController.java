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

@Controller   //@Controller + Controller의 역할(request,response를 사용하여 사용자(spring인 경우는 FrontController)와 소통)
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * @WebServlet("/") ===> spring에서는 @RequestMapping("/")
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
		
		return "home";   //접두사 : "home" + 접미사 
	                           ///WEB-INF/views/home.jsp 페이지에 forward 된다.                            
	}
	
}
