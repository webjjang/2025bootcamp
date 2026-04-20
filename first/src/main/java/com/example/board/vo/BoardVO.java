package com.example.board.vo;

import java.util.Date;

import lombok.Data;

// lombok이 제대로 적용이되었다면 @Data 어노테이션을 붙이면 getter, setter, toString() 등을 자동으로 만들어 준다.
@Data
public class BoardVO {

	private Long no;
	private String title; 
	private String content; 
	private String writer; 
	private Date writeDate; 
	private Long hit;
	private String pw; 
	
}
