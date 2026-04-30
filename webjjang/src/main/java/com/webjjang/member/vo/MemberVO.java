package com.webjjang.member.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberVO {

	// userNo - 숫자 pk 추가 하는 경우 - 숫자 비교가 빠르다. - id 대신에 처리한다.
	// 회원가입 - id, pw, pw2, name, gender, birth, tel, email
	private String id;
	private String pw;
	private String name;
	private String gender;
	// 사용자가 날짜 데이터를 입력 받을 때 자바 Date 맞춰야 한다. 패턴을 정해서 입력 받게 한다.
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;
	private String tel;
	private String email;
	private Date regDate;
	private Date conDate;
	private String status;
	private Integer gradeNo;
	private String gradeName;
	
}
