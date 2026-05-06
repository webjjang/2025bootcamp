package com.webjjang.notice.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class NoticeVO {

	private Long no;
	private String title;
	private String content;
	// 입력 받을 때 자동으로 매칭되는 패턴 지정
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	private Date writeDate;
	private Date updateDate;
	
}
