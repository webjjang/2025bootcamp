package com.webjjang.board.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.webjjang.board.vo.BoardVO;

@Repository
public interface BoardMapper {

	// 1. list
	public List<BoardVO> list();
	
	// 2. view
	// 3. write
	// 4. update
	// 5. delete
	
}
