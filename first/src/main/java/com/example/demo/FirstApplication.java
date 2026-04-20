package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// @어노테이션 -> 1. 타입 사용가능, 2. 데이터 저장(속성), 3. 확인
@SpringBootApplication
// 기본적으로 자동 객체 생성해서 저장할 위치는 기본 위의 패키지(com.example.demo)가 된다. 
// 기본적으로 생성은 기본 패키지의 아래에 위치한 객체를 생성
// 기본 패키지를 변경하려면 @ComponentScan를 사용한다.
@ComponentScan( "com.example")
public class FirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
	}

}
