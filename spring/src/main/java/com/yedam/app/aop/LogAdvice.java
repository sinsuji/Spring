package com.yedam.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect	   // aspect 설정
@Component // bean등록
public class LogAdvice {
	
	@Pointcut("execution( * com.yedam.app.emp..*Impl.*(..) )")
	public void allpointcut() { }
	
	// emp로 시작해서 Impl로 끝나는 클래스
	// (..) -> 모든
	//@실행시점(포인트컷)
	@Before("allpointcut()")
	public void logBefore(JoinPoint jp) {
		System.out.println("[log before]");
		String name = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println( name + " : ");
		if(args != null) {
			for(Object arg : args) {
				System.out.println(arg);
			}
		}
	}
}
