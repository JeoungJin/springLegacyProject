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
//Advice : ������ɻ��� �ڵ� 
@Component
@Aspect  //pointcut(����) + advice(��������)
public class LoggingAdvice  {

	//@Pointcut("execution(* selectAll(..))")
	@Pointcut("within(com.shinhan.spring.model.emp.EmpService)")
	public void targetMethod() { }   //������ ������ �Լ����¸� �����ϴ�. 
 
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

        //�ְ��ɻ� ������
		log.info("[�޼��� ȣ������ LoggingAdvice]" + jp.getSignature().getName());
		//�ְ��ɻ簡�� 
		Object obj = jp.proceed();
		log.info("[LoggingAdvice]�ְ��ɻ翡�� return����:" +obj );
		//�ְ��ɻ� �ٳ���� 
		log.info("[�޼��� ȣ������ LoggingAdvice]" + jp.getSignature().getName() + "*******");
		return obj;
	}

}
