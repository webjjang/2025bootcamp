package com.example.board.service;

import java.util.List;

import com.example.board.vo.BoardVO;

public interface BoardService {

	// 1. list
	public List<BoardVO> list();
	
	// 2. view
	public BoardVO view(Long no, int inc);
	
	// 3. write
	public Integer write(BoardVO vo);
	
	// 4. update
	public Integer update(BoardVO vo);
	
	// 5. delete
	public Integer delete(BoardVO vo);
	
}
