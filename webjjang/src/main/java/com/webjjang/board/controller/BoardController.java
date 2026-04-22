package com.webjjang.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/board")
@Log4j2
public class BoardController {

	@GetMapping("/list.do")
	public String list(Long page) {
		
		log.info("일반게시판 리스트");
		// @Log : log.info(str), @Log4j2 : log.info(Object)
		log.info(page);
		
		return "board/list";
	}
	
}
