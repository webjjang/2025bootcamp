package com.webjjang.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.webjjang.board.vo.BoardVO;
import com.webjjang.util.page.PageObject;

@Mapper
public interface BoardMapper {

	// 1-1. getTotalRow
	public Long getTotalRow();
	
	// 1-2. list
	public List<BoardVO> list(PageObject pageObject);
	
	// 2. view
	public BoardVO view(Long no);
	
	// 3. write
	public Integer write(BoardVO vo);
	
	// 4. update
	public Integer update(BoardVO vo);
	
	// 5. delete
	public Integer delete(BoardVO vo);
	
}
