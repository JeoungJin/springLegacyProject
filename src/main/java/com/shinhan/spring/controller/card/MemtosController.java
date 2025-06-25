package com.shinhan.spring.controller.card;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemtosController {

	@GetMapping("/hee")
	public String f1() {
		return "hee/mentos1";
	}
}
