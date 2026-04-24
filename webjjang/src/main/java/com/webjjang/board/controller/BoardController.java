package com.webjjang.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webjjang.board.service.BoardService;
import com.webjjang.board.vo.BoardVO;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/board")
@Log4j2
public class BoardController {

	// 생성된 객체를 자동 DI 시키는 @Autowired 스프링 어노테이션 사용
	@Autowired
	private BoardService service;
	
	//1. 리스트
	@GetMapping("/list.do")
	public String list(Long page, Model model) {
		
		log.info("일반게시판 리스트");
		// @Log : log.info(str), @Log4j2 : log.info(Object)
		log.info(page);
		
		// 서비스 실행해서 결과를 model에 담는다.
		model.addAttribute("list", service.list());
		
		return "board/list";
	}
	
	// 2. 글보기
	@GetMapping("/view.do")
	public String view(Long no, Integer inc, Model model) {
		log.info("일반게시판 글보기");
		log.info("no=" + no + ", inc=" + inc);
		model.addAttribute("vo", service.view(no, inc));
		return "board/view";
	}
	
	// 3-1. 글등록 폼
	@GetMapping("/writeForm.do")
	public String writeForm() {
		return "board/writeForm";
	}
	
	//3-2. 글등록 처리
	@PostMapping("/write.do")
	public String write(BoardVO vo) {
		service.write(vo);
		return "redirect:list.do";
	}
}
