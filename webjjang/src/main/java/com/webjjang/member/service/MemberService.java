package com.webjjang.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webjjang.member.mapper.MemberMapper;
import com.webjjang.member.vo.LoginVO;
import com.webjjang.member.vo.MemberVO;
import com.webjjang.util.page.PageObject;

@Service
public class MemberService {

	@Autowired
	private MemberMapper mapper;
	
	// 1. login & 최근 접속일 수정
	public LoginVO login(LoginVO vo) {
		LoginVO resultVO = mapper.login(vo);
		// 최근 접속일 처리 - 로그인 정보를 제대로 가져온 경우만 처리
		if(resultVO != null) mapper.setConDate(vo.getId());
		return resultVO;
	}
	
	// 2. id 중복 체크
	public String checkId(String id) {
		return mapper.checkId(id);
	}
	
	// 3. 회원가입
	public Integer write(MemberVO vo) {
		return mapper.write(vo);
	}
	
	// 4. 내/회원 정보 보기
	public MemberVO view(String id) {
		return mapper.view(id);
	};
	
	// 5. list
	public List<MemberVO> list(PageObject pageObject) {
		// JSP의 페이지 네이션 처리를 위한 계산 - setTotalRow() 호출
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		return mapper.list(pageObject);
	}
	
}
