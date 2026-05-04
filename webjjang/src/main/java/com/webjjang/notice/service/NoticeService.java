package com.webjjang.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webjjang.notice.mapper.NoticeMapper;
import com.webjjang.notice.vo.NoticeVO;
import com.webjjang.util.page.PageObject;

@Service
public class NoticeService {

	@Autowired
	private NoticeMapper mapper;
	
	// 1. list
	public List<NoticeVO> list(PageObject pageObject) {
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		return mapper.list(pageObject);
	}
	
	// 2. view
	public NoticeVO view(Long no) {
		return mapper.view(no);
	}
	
	// 3. write
	public Integer write(NoticeVO vo) {
		return mapper.write(vo);
	}
	
	// 4. update
	public Integer update(NoticeVO vo) {
		return mapper.update(vo);
	}
	
	// 5. delete
	public Integer delete(Long no) {
		return mapper.delete(no);
	}
	
}
