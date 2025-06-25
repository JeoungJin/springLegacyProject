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
 * static : @BeforeAll, @AfterAll, ....�ѹ��� ���� 
 * ��?@TestInstance(Lifecycle.PER_METHOD)�� default(�޼�������Ҷ�����)
 * @TestInstance(Lifecycle.PER_CLASS) :  �̶��� static�� �����Ѵ�. 
 * @BeforeEach,@AfterEach .... @Test���� ����
 */
@Slf4j
@TestInstance(Lifecycle.PER_CLASS)  
public class Test1_LifeCycle {

	Calculator cal;
	
	
	@BeforeAll
	@DisplayName("BeforeAll����")
	void before() {
		log.info("@BeforeAll--------1ȸ ���� ");
		cal = new Calculator();
	}
	
	@AfterAll
	@DisplayName("AfterAll����")
	void after() {
		log.info("@AfterAll--------1ȸ ���� ");
	}
	
	@BeforeEach
	@DisplayName("BeforeEach����")
	void before2() {
		log.info("@BeforeEach--------@Test�� ���� ���� ");
	}
	
	@AfterEach
	@DisplayName("AfterEach����")
	void after2() {
		log.info("@AfterEach--------@Test�� ���� ���� ");
	}
	
	@Test
	@DisplayName("���ϱ���1")
	void f1() {
		assertEquals(3, 1+2);
		assertEquals(30, cal.add(10, 20));
		assertEquals(-10, cal.subtract(10, 20));
		//assertEquals(-10, cal.multiply(10, 20));
		assertEquals(0, cal.divide(10, 20));
		log.info("���ϱ���1.....OK");
	}
	
	@Test
	@DisplayName("���ϱ���2")
	void f2() {
		assertEquals(3, 1+2);
		log.info("���ϱ���2.....OK");
	}
	
	
}





