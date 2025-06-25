package com.shinhan.spring.aop;
 
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//Advice : 공통관심사항 코드 
@Component
@Aspect  //pointcut(지점) + advice(보조업무)
public class LoggingAdvice  {

	//@Pointcut("execution(* selectAll(..))")
	@Pointcut("within(com.shinhan.spring.model.emp.EmpService)")
	public void targetMethod() { }   //로직은 없지만 함수형태만 가능하다. 
 
	@Before("targetMethod()")
	public void before2(JoinPoint jp) {
		String fname = jp.getSignature().getName();
		log.info("=============@Before==========" + fname);
	}
	
	@AfterReturning("targetMethod()")
	public void after2(JoinPoint jp) {
		String fname = jp.getSignature().getName();
		log.info("=============@AfterReturning==========" + fname);
	}
	
	@Around("targetMethod()")
	public Object around2(ProceedingJoinPoint jp) throws Throwable {

        //주관심사 가기전
		log.info("[메서드 호출전의 LoggingAdvice]" + jp.getSignature().getName());
		//주관심사가기 
		Object obj = jp.proceed();
		log.info("[LoggingAdvice]주관심사에서 return내용:" +obj );
		//주관심사 다녀온후 
		log.info("[메서드 호출후의 LoggingAdvice]" + jp.getSignature().getName() + "*******");
		return obj;
	}

}
