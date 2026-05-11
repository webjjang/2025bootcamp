package com.webjjang.boardreply.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.webjjang.boardreply.vo.BoardReplyVO;
import com.webjjang.util.page.PageObject;

@Mapper
public interface BoardReplyMapper {

	// 1-1. list
	public List<BoardReplyVO> list(PageObject pageObject);
	
	// 1-2. getTotalRow
	public Long getTotalRow(Long no);
	
	// 2. write
	public Integer write(BoardReplyVO vo);
	
	// 3. update
	public Integer update(BoardReplyVO vo);
	
	// 4. delete
	// 2개의 합쳐서 하나로 만든다. 주로 Map을 사용
	public Integer delete(@Param("rno") Long rno, @Param("id") String id);
	
}
