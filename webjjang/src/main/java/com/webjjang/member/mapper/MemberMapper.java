package com.webjjang.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.webjjang.member.vo.LoginVO;
import com.webjjang.member.vo.MemberVO;

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
	
}
