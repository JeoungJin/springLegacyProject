package com.shinhan.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shinhan.spring.model.board.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;

	@GetMapping("/boardlist")
	public void f1(Model model) {
		model.addAttribute("boardlist", boardService.selectAll());
	 
	}
	@GetMapping("/boardlist2")
	public void f2(Model model) {
		model.addAttribute("boardlist", boardService.selectAll());
	 
	}
	
}
