package com.shinhan.spring.section1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import lombok.extern.slf4j.Slf4j;
import net.firstzone.app.Calculator;

/*
 * LifeCycle
 * static : @BeforeAll, @AfterAll, ....한번만 수행 
 * 왜?@TestInstance(Lifecycle.PER_METHOD)가 default(메서드수행할때마다)
 * @TestInstance(Lifecycle.PER_CLASS) :  이때는 static를 생략한다. 
 * @BeforeEach,@AfterEach .... @Test마다 수행
 */
@Slf4j
@TestInstance(Lifecycle.PER_CLASS)  
public class Test1_LifeCycle {

	Calculator cal;
	
	
	@BeforeAll
	@DisplayName("BeforeAll연습")
	void before() {
		log.info("@BeforeAll--------1회 수행 ");
		cal = new Calculator();
	}
	
	@AfterAll
	@DisplayName("AfterAll연습")
	void after() {
		log.info("@AfterAll--------1회 수행 ");
	}
	
	@BeforeEach
	@DisplayName("BeforeEach연습")
	void before2() {
		log.info("@BeforeEach--------@Test전 마다 수행 ");
	}
	
	@AfterEach
	@DisplayName("AfterEach연습")
	void after2() {
		log.info("@AfterEach--------@Test후 마다 수행 ");
	}
	
	@Test
	@DisplayName("더하기결과1")
	void f1() {
		assertEquals(3, 1+2);
		assertEquals(30, cal.add(10, 20));
		assertEquals(-10, cal.subtract(10, 20));
		//assertEquals(-10, cal.multiply(10, 20));
		assertEquals(0, cal.divide(10, 20));
		log.info("더하기결과1.....OK");
	}
	
	@Test
	@DisplayName("더하기결과2")
	void f2() {
		assertEquals(3, 1+2);
		log.info("더하기결과2.....OK");
	}
	
	
}





