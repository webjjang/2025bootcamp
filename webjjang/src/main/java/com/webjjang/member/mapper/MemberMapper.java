package com.webjjang.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.webjjang.member.vo.LoginVO;

@Mapper
public interface MemberMapper {

	// 1. 로그인 처리
	public LoginVO login(LoginVO vo);
	
}
