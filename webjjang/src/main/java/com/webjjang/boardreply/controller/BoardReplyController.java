package com.webjjang.boardreply.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webjjang.boardreply.vo.BoardReplyVO;
import com.webjjang.util.page.PageObject;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/boardreply")
@Log4j2
public class BoardReplyController {

	// 1. list
	@GetMapping("/list.do")
	public List<BoardReplyVO> list(Long no, HttpServletRequest request) throws Exception {
		
		log.info("일반게시판 댓글 리스트");
		
		// 페이지 정보 받기
		PageObject pageObject = PageObject.getInstance(request);
		
		return null;
		
	}
	
	// 2. write
	// 3. update
	// 4. delete
	
}
