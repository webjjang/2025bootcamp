package com.webjjang.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webjjang.board.service.BoardService;
import com.webjjang.board.vo.BoardVO;
import com.webjjang.util.page.PageObject;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

// 자동생성되는 어노테이션
// - @Controller, @Service, @Mapper, @Repository, @Component, @RestController, @~Advice
@RestController
@RequestMapping("/boardApi")
@CrossOrigin(origins = "*") // Spring Boot 프로젝트(80포트)와 React 프록젝트(5173)는 서로 다른 것으로 인식한다.
@Log4j2
public class BoardRestController {

	// 생성된 객체를 자동 DI 시키는 @Autowired 스프링 어노테이션 사용
	@Autowired
	private BoardService service;
	
	//1. 리스트
	@GetMapping(value = "/list.do",
			// 넘겨 주는 데이터 타입
			produces = {
				MediaType.APPLICATION_JSON_VALUE
		})
//	public String list(Long page, Model model) 
	public ResponseEntity<Map<String, Object>> list(HttpServletRequest request) 
	throws Exception {
		
		log.info("일반게시판 API 리스트");
		// @Log : log.info(str), @Log4j2 : log.info(Object)
		// log.info(page);
		// PageObject을 이용해서 넘어오는 페이지 정보와 검색 정보를 받는다.
		PageObject pageObject = PageObject.getInstance(request);
		
		// 넘겨 주는 데이터 변수 - 댓글 리스트 데이터 + PageObject
		Map<String, Object> map = new HashMap<>();
		
		// 서비스 실행해서 결과를 변수에 담는다.
		List<BoardVO> list = service.list(pageObject);
		
		map.put("list", list);
		// pageObjcet
		map.put("pageObject", pageObject);
				
		return  new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	// 2. 글보기
	@GetMapping(
			value = "/view.do",
			// 넘겨 주는 데이터 타입
			produces = {
				MediaType.APPLICATION_JSON_VALUE
			}
	)
	public ResponseEntity<BoardVO> view(Long no, Integer inc) {
		log.info("일반게시판(API) 글보기");
		log.info("no=" + no + ", inc=" + inc);
		BoardVO vo = service.view(no, inc);
		if(vo != null)
			return new ResponseEntity<BoardVO>(vo, HttpStatus.OK);
		else return new ResponseEntity<BoardVO>(vo, HttpStatus.BAD_REQUEST);
	}
	
	
	// 3. 글등록 처리
	@PostMapping(
			value = "/write.do"
	)
	public ResponseEntity<String> write(@RequestBody BoardVO vo){
		service.write(vo);
		return new ResponseEntity<String>("일반 게시판에 글등록이 되었습니다.", HttpStatus.OK);
	}
	
	
	// 4. 글수정 처리
	@PostMapping(
			value = "/update.do"
	)
	public ResponseEntity<String> update(@RequestBody BoardVO vo){
		Integer result = service.update(vo);
		if(result == 1)
			return new ResponseEntity<String>("일반 게시판에 글수정이 되었습니다.", HttpStatus.OK);
		else
			return new ResponseEntity<String>("일반 게시판에 글수정에 실패 하였습니다.", HttpStatus.NOT_MODIFIED);
	}
	
	// 5. 글삭제 처리
	@PostMapping(
			value = "/delete.do"
	)
	public ResponseEntity<String> delete(@RequestBody BoardVO vo){
		Integer result = service.delete(vo);
		if(result == 1)
			return new ResponseEntity<String>("일반 게시판에 글삭제가 되었습니다.", HttpStatus.OK);
		else
			return new ResponseEntity<String>("일반 게시판에 글삭제에 실패 하였습니다.", HttpStatus.NOT_MODIFIED);
	}
	
	
	
}
