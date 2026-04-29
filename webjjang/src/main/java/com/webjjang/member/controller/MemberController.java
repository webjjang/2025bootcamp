package com.webjjang.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webjjang.member.vo.LoginVO;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/member")
@Log4j2
public class MemberController {

	// 1-1. login 폼
	@GetMapping("/loginForm.do")
	public String loginForm(Model model) {
		
		// 내용에 해당되는 JSP 정보를 contentPage
		model.addAttribute("contentPage", "../member/loginForm.jsp");
		// 창이름
		model.addAttribute("title", "로그인 폼");
		
		return "main/main";
	}
	
	// 1-2. login 처리
	public String login(LoginVO vo) {
		
		return "redirect:/board/list.do";
	}
	// 2. logout
	
}
