package com.webjjang.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.webjjang.board.vo.BoardVO;

@Mapper
public interface BoardMapper {

	// 1. list
	public List<BoardVO> list();
	
	// 2. view
	public BoardVO view(Long no);
	
	// 3. write
	public Integer writer(BoardVO vo);
	
	// 4. update
	public Integer update(BoardVO vo);
	
	// 5. delete
	public Integer delete(BoardVO vo);
	
}
