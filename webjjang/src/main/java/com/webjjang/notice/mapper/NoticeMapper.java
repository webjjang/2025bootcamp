package com.webjjang.notice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.webjjang.notice.vo.NoticeVO;
import com.webjjang.util.page.PageObject;

@Mapper
public interface NoticeMapper {

	// 1-1. list
	public List<NoticeVO> list(PageObject pageObject);
	
	// 1-2. getTotalRow
	public Long getTotalRow(PageObject pageObject);
	
	// 2. view
	public NoticeVO view(Long no);
	
	// 3. write
	public Integer write(NoticeVO vo);
	
	// 4. update
	public Integer update(NoticeVO vo);
	
	// 5. delete
	public Integer delete(Long no);
	
}
