package com.webjjang.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webjjang.member.mapper.MemberMapper;
import com.webjjang.member.vo.LoginVO;

@Service
public class MemberService {

	@Autowired
	private MemberMapper mapper;
	
	// 1. login
	public LoginVO login(LoginVO vo) {
		return mapper.login(vo);
	}
	
	// 2. id 중복 체크
	public String checkId(String id) {
		return mapper.checkId(id);
	}
	
}
