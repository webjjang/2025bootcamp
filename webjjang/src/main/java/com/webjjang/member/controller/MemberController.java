package com.webjjang.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webjjang.member.service.MemberService;
import com.webjjang.member.vo.LoginVO;

import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/member")
@Log4j2
public class MemberController {

	@Autowired
	private MemberService service;
	
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
	@PostMapping("/login.do")
	public String login(LoginVO vo, HttpSession session, RedirectAttributes rttr) {
		
		// 아이디와 비밀번호가 맞으면 LoginVO 객체가 저장 - 데이터 존재
		// 맞지 않으면 null 이 저장 - 데이터가 존재하지 않는다. - empty
		session.setAttribute("login", service.login(vo));
		if(session.getAttribute("login") == null) {
			rttr.addFlashAttribute("msg", "로그인 오류<hr>정보를 확인하고 다시 시도해 주세요.");
			return "redirect:/member/loginForm.do";
		}
		
		rttr.addFlashAttribute("msg", "로그인이 되었습니다.<hr>즐거운 시간되세요.");
		return "redirect:/board/list.do";
	}
	
	// 2. logout
	@GetMapping("/logout.do")
	public String logout(HttpSession session, RedirectAttributes rttr) {
		
		// 로그인 정보를 지운다.
		session.removeAttribute("login");
		// session.invalidate(); // session 객체를 전체 다 없앤다.
		
		// 메세지 처리
		rttr.addFlashAttribute("msg", "로그아웃 되었습니다.<hr>불편한 점이 있으시면 고객센테를 이용해 주세요.");
		
		return "redirect:/board/list.do";
	}
	
}
