package com.webjjang.board.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BoardVO {

	private Long no;
	private String title;
	private String content;
	private String writer;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date writeDate;// java.sql.Date -> java.util.Date : Spring에서는 자동 변환해서 담는다.
	private Long hit;
	private String pw;
	
}
