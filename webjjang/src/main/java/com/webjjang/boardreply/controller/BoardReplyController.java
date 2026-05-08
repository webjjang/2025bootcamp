package com.webjjang.boardreply.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webjjang.boardreply.service.BoardReplyService;
import com.webjjang.boardreply.vo.BoardReplyVO;
import com.webjjang.util.page.PageObject;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/boardreply")
@Log4j2
public class BoardReplyController {

	@Autowired
	private BoardReplyService service;
	
	// 1. list
	@GetMapping(value = "/list.do",
		// 넘겨 주는 데이터 타입
		produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<Map<String, Object>> list(Long no, HttpServletRequest request) throws Exception {
		
		log.info("일반게시판 댓글 리스트");
		
		// 넘겨 주는 데이터 변수 - 댓글 리스트 데이터 + PageObject
		Map<String, Object> map = new HashMap<>();
		
		// 페이지 정보 받기
		PageObject pageObject = PageObject.getInstance(request);
		// 일반 게시판 글번호 세팅
		pageObject.setNo(Long.parseLong(request.getParameter("no")));
		
		// list 데이터 - null
		map.put("list", service.list(pageObject));
		// pageObjcet
		map.put("pageObject", pageObject);
		
		return new ResponseEntity<>(map, HttpStatus.OK);
		
	}
	
	// 2. write
	// 3. update
	// 4. delete
	
}
