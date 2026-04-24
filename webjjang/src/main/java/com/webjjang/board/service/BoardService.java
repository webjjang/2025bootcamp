package com.webjjang.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webjjang.board.mapper.BoardMapper;
import com.webjjang.board.vo.BoardVO;

import lombok.extern.log4j.Log4j2;

// 자동 생성되는 어노테이션 - 기본 패키지 아래 있어야 자동 생성된다.
// Controller, Service, Repository, Component, RestController, ~Advice
@Service
@Log4j2
public class BoardService {

	@Autowired
	private BoardMapper mapper;
	
	public List<BoardVO> list() {
		log.info("일반게시판 처리");
		return mapper.list();
	}
	
	public BoardVO view(Long no, Integer inc) {
		return mapper.view(no);
	}
	
	// 3. write
	public Integer writer(BoardVO vo) {
		return mapper.writer(vo);
	}
	
	// 4. update
	public Integer update(BoardVO vo) {
		return mapper.update(vo);
	}
	
	// 5. delete
	public Integer delete(BoardVO vo) {
		return mapper.delete(vo);
	}
	
	
}
