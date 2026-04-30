package com.webjjang.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webjjang.board.service.BoardService;
import com.webjjang.board.vo.BoardVO;
import com.webjjang.util.page.PageObject;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

// 자동생성되는 어노테이션
// - @Controller, @Service, @Mapper, @Repository, @Component, @RestController, @~Advice
@Controller
@RequestMapping("/board")
@Log4j2
public class BoardController {

	// 생성된 객체를 자동 DI 시키는 @Autowired 스프링 어노테이션 사용
	@Autowired
	private BoardService service;
	
	//1. 리스트
	@GetMapping("/list.do")
//	public String list(Long page, Model model) 
	public String list(Model model, HttpServletRequest request) 
	throws Exception {
		
		log.info("일반게시판 리스트");
		// @Log : log.info(str), @Log4j2 : log.info(Object)
		// log.info(page);
		// PageObject을 이용해서 넘어오는 페이지 정보와 검색 정보를 받는다.
		PageObject pageObject = PageObject.getInstance(request);
		
		// 서비스 실행해서 결과를 model에 담는다.
		model.addAttribute("list", service.list(pageObject));
		// 화면에 페이지 네이션 처리를 위해서 pageObject를 담아서 넘긴다.
		model.addAttribute("pageObject", pageObject);
		
		// 내용에 해당되는 JSP 정보를 contentPage
		model.addAttribute("contentPage", "../board/list.jsp");
		// 창이름
		model.addAttribute("title", "일반게시판 리스트");
				
		return "main/main";
	}
	
	// 2. 글보기
	@GetMapping("/view.do")
	public String view(Long no, Integer inc, Model model) {
		log.info("일반게시판 글보기");
		log.info("no=" + no + ", inc=" + inc);
		model.addAttribute("vo", service.view(no, inc));
		
		// 내용에 해당되는 JSP 정보를 contentPage
		model.addAttribute("contentPage", "../board/view.jsp");
		// 창이름
		model.addAttribute("title", "일반게시판 글보기");
				
		return "main/main";
	}
	
	// 3-1. 글등록 폼
	@GetMapping("/writeForm.do")
	public String writeForm(Model model) {
		// 내용에 해당되는 JSP 정보를 contentPage
		model.addAttribute("contentPage", "../board/writeForm.jsp");
		// 창이름
		model.addAttribute("title", "일반게시판 글등록 폼");
				
		return "main/main";
	}
	
	//3-2. 글등록 처리
	@PostMapping("/write.do")
	public String write(BoardVO vo, @RequestParam(defaultValue = "10") Integer perPageNum, RedirectAttributes rttr) {
		service.write(vo);
		rttr.addFlashAttribute("msg", "일반 게시판 글등록이 되었습니다."); // session을 사용한 잠시 존재하는 데이터 처리
		return "redirect:list.do?perPageNum=" + perPageNum;
	}
	
	// 4-1. 글수정 폼
	@GetMapping("/updateForm.do")
	public String updateForm(Long no, Model model) {
		model.addAttribute("vo", service.view(no, 0));
		// 내용에 해당되는 JSP 정보를 contentPage
		model.addAttribute("contentPage", "../board/updateForm.jsp");
		// 창이름
		model.addAttribute("title", "일반게시판 글수정");
				
		return "main/main";
	}
	
	//4-2. 글수정 처리
	@PostMapping("/update.do")
	public String update(BoardVO vo, HttpServletRequest request, RedirectAttributes rttr) throws Exception {
		// 페이지 정보와 검색 정보를 받는다.
		PageObject pageObject = PageObject.getInstance(request);
		Integer result = service.update(vo);
		if (result == 1) rttr.addFlashAttribute("msg", "일반 게시판 글수정이 되었습니다.");
		else rttr.addFlashAttribute("msg", "일반 게시판 글수정에 실패 하였습니다.<hr>정보를 확인하고 다시 시도해 주세요.");
		return "redirect:view.do?no=" + vo.getNo() + "&inc=0&" + pageObject.getPageQuery();
	}
	
	// 5. 글삭제 처리
	@PostMapping("/delete.do")
	public String delete(BoardVO vo, RedirectAttributes rttr, HttpServletRequest request) throws Exception {
		// 페이지 정보와 검색 정보를 받기
		PageObject pageObject = PageObject.getInstance(request);
		
		// 삭제 처리
		Integer result = service.delete(vo);
		if (result == 1) { 
			rttr.addFlashAttribute("msg", "일반 게시판 글삭제가 되었습니다.");
			return "redirect:list.do?perPageNum=" + pageObject.getPerPageNum();
		} else {
			rttr.addFlashAttribute("msg", "일반 게시판 글삭제가 되지 않았습니다.<hr>정보를 확인하고 다시 시도해 주세요.");
			return "redirect:view.do?no=" + vo.getNo() + "&inc=0&" + pageObject.getPageQuery();
		}
		
	}
	
	
}
