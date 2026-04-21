package com.example.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.board.service.BoardService;
import com.example.board.vo.BoardVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;

//@어노테이션 -> 1. 타입 사용가능, 2. 데이터 저장(속성), 3. 확인
// 기본 패키지(com.example) 안에 있어서 자동생성된다.
// --  자동 생성되는 어노테이션 타입 ---//
//  @Controller - URL과 연결되어 적용된다.
//  @Service - 데이터 처리
//  @Repository - DB 관련 처리
//  @Component - 구성 객체. 다른 프로그램을 도와주는 객체
//  @RestController - URL과 연결되어 REST(html이 아닌 순수 데이터) 제공.
//  @~~Advice - 예외처리 객체
@Controller
// URL 서버 접근 여러가지 방식
// @RequestMapping - 전체 전급
// HTML에서 자주 사용되는 접근 방식 
// - 데이터의 위치에 따른 구분 - @GetMapping, @PostMapping
// - 처리 방식에 따른 구분 - @PatchMapping, @PutMapping, @DeleteMapping
@RequestMapping("/board")
// 로그 출력하기 위한 객체 사용 - log.info(data), long.warning(data)
@Log
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	// 1.일반 게시판 리스트 - list.do : get
	// @GetMapping - 1. 주소 입력란에 입력해서 요청. 2. html의 a tag. 
	// 3. js : location=uri 4. form method 설정을 안했거난 get으로 설정
	@GetMapping("/list.do")
	// 넘겨 받는데 데이터 처리
	// - page - long : String -> long : 데이터가 없으면 오류
	//    Long : String -> Long - null로 세팅 오류가 안난다.
	// request -> Model / ModelAndView
	// MVC - Model + View::JSP + C::Controller
	// html 이나 주소의 name 이 변수 이름과 같아야 하는데 다르면 @RequestParam 안에 name 을 지정한다
	// 만약에 페이지가 넘어오지 않으면 기본값 세팅 defaultValue 속성으로 세팅한다. 문자열로 한다.
	public String list(@RequestParam(name = "page", defaultValue = "1") Long page,
			Model model, HttpSession session, HttpServletRequest request) {
		log.info("일반게시판 리스트");
		log.info("page=" + page);
		service.list();
		model.addAttribute("list","리스트 데이터 입니다.");
		return "board/list";
	}
	
	// 2.일반 게시판 글보기 : get
	@GetMapping("/view.do")
	public String view(Long no, int inc) {
		log.info("일반게시판 글보기");
		log.info("no=" + no + ", inc=" + inc);
		return "board/view";
	}
	
	// 3-1.일반 게시판 글등록 폼 : get
	@GetMapping("/writeForm.do")
	public String writeForm() {
		log.info("일반게시판 글등록 폼");
		return "board/writeForm";
	}
	
	// 3-2.일반 게시판 글등록 처리 : post
	@PostMapping("/write.do")
	public String write(BoardVO vo) {
		log.info("일반게시판 글등록");
		log.info(vo.toString());
		return "redirect:list.do";
	}
	
	// 4-1.일반 게시판 글수정 폼 : get
	@GetMapping("/updateForm.do")
	public String updateForm() {
		log.info("일반게시판 글수정 폼");
		return "board/updateForm";
	}
	
	// 4-2.일반 게시판 글수정 처리 : post
	@PostMapping("/update.do")
	public String update() {
		log.info("일반게시판 글수정 처리");
		return "redirect:view.do";
	}
	
	// 5.일반 게시판 글삭제 : post
	@PostMapping("/delete.do")
	public String delete(BoardVO vo) {
		log.info("일반게시판 글삭제");
		log.info(vo.toString());
		return "redirect:list.do";
	}
	
}
