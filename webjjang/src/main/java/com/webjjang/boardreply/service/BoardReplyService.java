package com.webjjang.boardreply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webjjang.boardreply.mapper.BoardReplyMapper;
import com.webjjang.boardreply.vo.BoardReplyVO;
import com.webjjang.util.page.PageObject;

@Service
public class BoardReplyService {

	@Autowired
	private BoardReplyMapper mapper;
	
	// 1. list
	public List<BoardReplyVO> list(PageObject pageObject){
		// 전체 데이터 개수 가져와서 세팅하기 - 프론트 엔트 쪽에 페이지 네이션 처리 데이터의 계산이 안된다.
		pageObject.setTotalRow(mapper.getTotalRow(pageObject.getNo()));
		return mapper.list(pageObject);
	}
	
	// 2. write
	// 3. update
	// 4. delete
	
}
