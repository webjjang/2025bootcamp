package com.webjjang.member.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {

	// userNo - 숫자 pk 추가 하는 경우 - 숫자 비교가 빠르다. - id 대신에 처리한다.
	private String id;
	private String pw;
	private String name;
	private String gender;
	private Date birth;
	private String tel;
	private String email;
	private Date regDate;
	private Date conDate;
	private String status;
	private Integer gradeNo;
	private String gradeName;
	
}
