package com.webjjang.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webjjang.member.service.MemberService;
import com.webjjang.member.vo.LoginVO;
import com.webjjang.member.vo.MemberVO;

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
	
	// 3. 회원 가입 폼
	@GetMapping("/writeForm.do")
	public String writeForm(Model model) {
		
		// 내용에 해당되는 JSP 정보를 contentPage
		model.addAttribute("contentPage", "../member/writeForm.jsp");
		// 창이름
		model.addAttribute("title", "회원가입 폼");
		
		return "main/main";
	}
	
	// 3-2. 아이디 중복 체크
	@GetMapping("/checkId.do")
	// @Controller에서 순수한 정보 데이터를 그대로 넘기자 - Rest Data
	// Rest API 서버에서는 @ResponseBody 메서드에 다붙이게 된다.
	// -> @RestController 만들고 어노테이션을 붙이지 않는다.
	@ResponseBody
	public String checkId(String id) {
		String resultId = service.checkId(id);
		return (resultId == null)?"":resultId;
	}
	
	// 3-3. 회원 가입 처리
	@PostMapping("/write.do")
	public String write(MemberVO vo, RedirectAttributes rttr) {
		
		service.write(vo);
		
		rttr.addFlashAttribute("msg", "회원 가입이 성공적으로 되었습니다.<hr>로그인 후 사용하세요~~");
		
		return "redirect:/board/list.do";
	}
	
	// 4. 내/회원 정보 보기 - 회원 정보 보기 : 아이디가 넘어온다.
	// 				내 정보 보기 : 아이디가 안 넘어 온다. session에서 꺼낸다.
	@GetMapping("/view.do")
	public String view(String id, Model model, HttpSession session) {
		
		// 내 정보(true) 또는 회원 정보(false)
		Boolean isMine = false;
		
		if(id == null) {
			isMine = true;
			// session에서 아이디 꺼내오기
			id = ((LoginVO)session.getAttribute("login")).getId();
		}
		
		// 내용에 해당되는 JSP 정보를 contentPage
		model.addAttribute("contentPage", "../member/view.jsp");
		// 창이름
		model.addAttribute("title", (isMine)?"내 정보 보기":"회원 정보 보기");
		
		return "main/main";
	}
	
}
