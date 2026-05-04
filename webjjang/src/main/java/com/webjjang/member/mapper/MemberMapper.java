package com.webjjang.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.webjjang.member.vo.LoginVO;
import com.webjjang.member.vo.MemberVO;
import com.webjjang.util.page.PageObject;

@Mapper
public interface MemberMapper {

	// 1-1. 로그인 처리
	public LoginVO login(LoginVO vo);
	
	// 1-2. 최근 접속일 수정
	public Integer setConDate(String id);
	
	// 2. id 중복 체크
	public String checkId(String id);
	
	// 3. 회원 가입
	public Integer write(MemberVO vo);
	
	// 4. 내/회원 정보 보기
	public MemberVO view(String id);
	
	// 5. list
	public List<MemberVO> list(PageObject pageObject);
	
	// 5-2 getTotalRow
	public Long getTotalRow(PageObject pageObject);
	
}
