package com.webjjang.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.webjjang.board.vo.BoardVO;

import lombok.extern.log4j.Log4j2;

// 자동 생성되는 어노테이션 - 기본 패키지 아래 있어야 자동 생성된다.
// Controller, Service, Repository, Component, RestController, ~Advice
@Service
@Log4j2
public class BoardService {

	public List<BoardVO> list() {
		log.info("일반게시판 처리");
		return null;
	}
	
}
