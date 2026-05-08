package com.webjjang.boardreply.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardReplyVO {

	private Long rno;
	private Long no;
	private String content;
	private String id;
	private String name;
	private Date writeDate;
	private Integer sameId; // 기본 값은 0, vo.id와 login.id가 같으면 1로 세팅해 준다.
}
