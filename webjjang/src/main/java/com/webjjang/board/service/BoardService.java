package com.webjjang.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webjjang.board.mapper.BoardMapper;
import com.webjjang.board.vo.BoardVO;
import com.webjjang.util.page.PageObject;

import lombok.extern.log4j.Log4j2;

// 자동 생성되는 어노테이션 - 기본 패키지 아래 있어야 자동 생성된다.
// Controller, Service, Repository, Component, RestController, ~Advice
@Service
@Log4j2
public class BoardService {

	@Autowired
	private BoardMapper mapper;
	
	public List<BoardVO> list(PageObject pageObject) {
		log.info("일반게시판 처리");
		// setTotalRow
		pageObject.setTotalRow(mapper.getTotalRow());
		return mapper.list(pageObject);
	}
	
	public BoardVO view(Long no, Integer inc) {
		// inc = 1일때만 조회수 1 증가시킨다.
		if(inc == 1) mapper.increase(no);
		return mapper.view(no);
	}
	
	// 3. write
	public Integer write(BoardVO vo) {
		return mapper.write(vo);
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
