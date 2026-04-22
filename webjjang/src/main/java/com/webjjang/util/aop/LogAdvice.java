package com.webjjang.util.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

// 작성하는 객체가 AOP 프로그램임을 알려주는 어노테이션
@Aspect
// 자동 객체 생성하는 어노테이션
// @Controller, @Service, @Repository, @Component, @RestController, @~Advice
@Component
// log 객체 사용 - Object를 출력
@Log4j2
public class LogAdvice {

	// * - 모든 문자 대체
	// (..) 전달되는 데이터 여러 개 배열로 받아진다.
	@Around("execution(* com.webjjang.*.service.*.*(..))")
    public Object logTime(ProceedingJoinPoint pjp) throws Throwable {

        // 1. 실행되는 객체 및 메서드 이름 찾아서 변수에 저장한다.
        String className = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();

        log.info("====================================");
        log.info("실행 클래스: " + className);
        log.info("실행 메서드: " + methodName);

        // 2. 전달되는 데이터 출력
        Object[] args = pjp.getArgs();
        log.info("전달 파라미터: " + Arrays.toString(args));

        // 실행 시간 측정 시작
        // long start = System.currentTimeMillis();
        long start = System.nanoTime();

        // 실제 메서드 실행해서 결과를 저장해 놓는다.
        Object result = pjp.proceed();

        //long end = System.currentTimeMillis();
        long end = System.nanoTime();

        // 3. 실행 결과 출력
        log.info("실행 결과: " + result);

        // 4. 실행 시간 출력
        log.info("실행 시간(ms): " + (end - start));

        log.info("====================================");

        return result;
    	
    }
	
}
