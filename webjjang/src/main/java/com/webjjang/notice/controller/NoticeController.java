package com.webjjang.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/notice")
@Log4j2
public class NoticeController {

	// 1.list
	@GetMapping("/list.do")
	public String list(Model model) {
		
		// 내용에 해당되는 JSP 정보를 contentPage
		model.addAttribute("contentPage", "../notice/list.jsp");
		// 창이름
		model.addAttribute("title", "공지 리스트");
				
		return "main/main";
	}
	
	// 2. view
	@GetMapping("/view.do")
	public String view(Model model) {
		
		// 내용에 해당되는 JSP 정보를 contentPage
		model.addAttribute("contentPage", "../notice/view.jsp");
		// 창이름
		model.addAttribute("title", "공지 상세보기");
				
		return "main/main";
	}
	
	
	// 3. writeForm
	@GetMapping("/writeForm.do")
	public String writeForm(Model model) {
		
		// 내용에 해당되는 JSP 정보를 contentPage
		model.addAttribute("contentPage", "../notice/writeForm.jsp");
		// 창이름
		model.addAttribute("title", "공지 등록");
				
		return "main/main";
	}
	
	// 4. write
	@PostMapping("/write.do")
	public String write(RedirectAttributes rttr) {
		
		// 메시지 처리
		rttr.addFlashAttribute("msg", "새로운 공지가 등록되었습니다.");
				
		return "redirect:list.do";
	}
	
	
	// 5. updateForm
	@GetMapping("/updateForm.do")
	public String updateForm(Model model) {
		
		// 내용에 해당되는 JSP 정보를 contentPage
		model.addAttribute("contentPage", "../notice/updateForm.jsp");
		// 창이름
		model.addAttribute("title", "공지 수정");
				
		return "main/main";
	}
	
	// 6. update
	@PostMapping("/update.do")
	public String update(RedirectAttributes rttr) {
		
		// 수정이 되었는지 결과에 따라 처리가 다름 if
		
		// 메시지 처리
		rttr.addFlashAttribute("msg", "새로운 공지가 등록되었습니다.");
				
		return "redirect:list.do";
	}
	
	
	// 7. delete
	@GetMapping("/delete.do")
	public String delete(RedirectAttributes rttr) {
		
		// 수정이 되었는지 결과에 따라 처리가 다름 if
		
		// 메시지 처리
		rttr.addFlashAttribute("msg", "공지가 삭제되었습니다.");
				
		return "redirect:list.do";
	}
	
	
}
