package com.webjjang.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webjjang.board.service.BoardService;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/board")
@Log4j2
public class BoardController {

	// 생성된 객체를 자동 DI 시키는 @Autowired 스프링 어노테이션 사용
	@Autowired
	private BoardService service;
	
	@GetMapping("/list.do")
	public String list(Long page) {
		
		log.info("일반게시판 리스트");
		// @Log : log.info(str), @Log4j2 : log.info(Object)
		log.info(page);
		
		// 서비스 실행
		service.list();
		
		return "board/list";
	}
	
}
