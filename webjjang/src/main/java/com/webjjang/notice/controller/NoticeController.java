package com.webjjang.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webjjang.notice.service.NoticeService;
import com.webjjang.notice.vo.NoticeVO;
import com.webjjang.util.page.PageObject;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/notice")
@Log4j2
public class NoticeController {

	@Autowired
	private NoticeService service;
	
	// 1.list
	@GetMapping("/list.do")
	public String list(String period, Model model, HttpServletRequest request) throws Exception {
		
		PageObject pageObject = PageObject.getInstance(request);
		if(period != null && !period.equals("")) pageObject.setPeriod(period);
		
		// DB 데이터 모델 담기
		model.addAttribute("list", service.list(pageObject));
		
		// PageObject 모델 담기 - JSP에서 pageNav 처리
		model.addAttribute("pageObject", pageObject);
		
		// 내용에 해당되는 JSP 정보를 contentPage
		model.addAttribute("contentPage", "../notice/list.jsp");
		// 창이름
		model.addAttribute("title", "공지 리스트");
				
		return "main/main";
	}
	
	// 2. view
	@GetMapping("/view.do")
	public String view(Long no, Model model) {
		
		// DB에 있는 데이터 가져와서 model에 담기
		model.addAttribute("vo", service.view(no));
		
		// 내용에 해당되는 JSP 정보를 contentPage
		model.addAttribute("contentPage", "../notice/view.jsp");
		// 창이름
		model.addAttribute("title", "공지 상세보기");
				
		return "main/main";
	}
	
	
	// 3. writeForm
	// a tag로 넘겨진 방식 - get
	@GetMapping("/writeForm.do")
	public String writeForm(Model model) {
		
		// 내용에 해당되는 JSP 정보를 contentPage
		model.addAttribute("contentPage", "../notice/writeForm.jsp");
		// 창이름
		model.addAttribute("title", "공지 등록");
				
		return "main/main";
	}
	
	// 4. write
	// form tag의 method 가 post로 지정
	@PostMapping("/write.do")
	public String write(NoticeVO vo, Integer perPageNum, RedirectAttributes rttr) {
		
		log.info("NoticeVO = " + vo);
		log.info("perPageNum = " + perPageNum);
		
		// DB
		service.write(vo);
		
		// 메시지 처리
		rttr.addFlashAttribute("msg", "새로운 공지가 등록되었습니다.");
				
		return "redirect:list.do?perPageNum=" + perPageNum;
	}
	
	
	// 5. updateForm
	@GetMapping("/updateForm.do")
	public String updateForm(Long no, Model model) {
		
		// DB에서 데이터 가져오기 - 공지 보기 처리
		model.addAttribute("vo", service.view(no));
		
		// 내용에 해당되는 JSP 정보를 contentPage
		model.addAttribute("contentPage", "../notice/updateForm.jsp");
		// 창이름
		model.addAttribute("title", "공지 수정");
				
		return "main/main";
	}
	
	// 6. update
	@PostMapping("/update.do")
	public String update(NoticeVO vo, String period, RedirectAttributes rttr, HttpServletRequest request)
			throws Exception {
		
		PageObject pageObject = PageObject.getInstance(request);
		
		// 수정이 되었는지 결과에 따라 처리가 다름 if
		Integer result = service.update(vo);
		
		// 메시지 처리
		if(result == 1) rttr.addFlashAttribute("msg", "공지 수정이 되었습니다.");
		else rttr.addFlashAttribute("msg", "공지 수정에 실패하였습니다.");
				
		return "redirect:view.do?no=" + vo.getNo() + "&" + pageObject.getPageQuery() + "&period=" +period;
	}
	
	
	// 7. delete
	@GetMapping("/delete.do")
	public String delete(Long no, Integer perPageNum, RedirectAttributes rttr) {
		
		// 수정이 되었는지 결과에 따라 처리가 다름 if
		Integer result = service.delete(no);
		
		// 메시지 처리
		if(result == 1 ) rttr.addFlashAttribute("msg", "공지가 삭제되었습니다.");
		else rttr.addFlashAttribute("msg", "공지삭제에 실패하였습니다.");
				
		return "redirect:list.do?perPageNum=" + perPageNum;
	}
	
	
}
