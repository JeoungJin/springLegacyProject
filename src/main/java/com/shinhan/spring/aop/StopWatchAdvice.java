package com.shinhan.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

//Advice : 공통관심사항 코드 
@Slf4j
@Component
@Aspect  //advice(보조업무) + pointcut(target의 지점)
public class StopWatchAdvice  {

	//@Pointcut("execution(* selectAll(..))")
	//public void targetMethod1() {}
	
	@Pointcut("within(com.shinhan.spring.model.emp.EmpService)")
	public void targetMethod2() {}
	
	@Around("targetMethod2()") //주업무 전후로 수행되는 보조업무임. 	
	public Object fffff(ProceedingJoinPoint jp) throws Throwable {

        //주관심사 가기전
		log.info("[메서드 호출전의 StopWatchAdvice]" + jp.getSignature().getName());
		StopWatch watch = new StopWatch("수행시간");
		watch.start();
		//주관심사가기 
		Object obj = jp.proceed();
		//System.out.println("[StopWatchAdvice]주관심사에서 return내용:" +obj );
		//주관심사 다녀온후 
		watch.stop();
		log.info("[메서드 호출후의 StopWatchAdvice]" +  jp.getSignature().getName() + "######");
		log.info("수행하는 걸린시간:" +watch.getTotalTimeMillis() );
		return obj;
	}

}
