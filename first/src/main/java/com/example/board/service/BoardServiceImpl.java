package com.example.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.board.vo.BoardVO;

import lombok.extern.java.Log;

//@어노테이션 -> 1. 타입 사용가능, 2. 데이터 저장(속성), 3. 확인
//기본 패키지(com.example) 안에 있어서 자동생성된다.
//--  자동 생성되는 어노테이션 타입 ---//
//@Controller - URL과 연결되어 적용된다.
//@Service - 데이터 처리
//@Repository - DB 관련 처리
//@Component - 구성 객체. 다른 프로그램을 도와주는 객체
//@RestController - URL과 연결되어 REST(html이 아닌 순수 데이터) 제공.
//@~~Advice - 예외처리 객체
@Service
@Qualifier("boardServiceImpl")
@Log
public class BoardServiceImpl implements BoardService{

	@Override
	public List<BoardVO> list() {
		// TODO Auto-generated method stub
		log.info("일반게시판 리스트 처리");
		return null;
	}

	@Override
	public BoardVO view(Long no, int inc) {
		// TODO Auto-generated method stub
		log.info("일반게시판 글보기 처리");
		return null;
	}

	@Override
	public Integer write(BoardVO vo) {
		// TODO Auto-generated method stub
		log.info("일반게시판 글등록 처리");
		return null;
	}

	@Override
	public Integer update(BoardVO vo) {
		// TODO Auto-generated method stub
		log.info("일반게시판 글수정 처리");
		return null;
	}

	@Override
	public Integer delete(BoardVO vo) {
		// TODO Auto-generated method stub
		log.info("일반게시판 글삭제 처리");
		return null;
	}

}
