package com.shinhan.spring.section1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import net.firstzone.app.Calculator;

@Slf4j
public class Test2_Basic {

	Calculator cal = new Calculator();
	
	@Test
	@DisplayName("���ϱ�")
	void f1() {
		assertEquals(30, cal.add(10, 20), "30�̾���մϴ�.");  
	}
	@Test
	@DisplayName("���ϱ�2")
	void f2() {
		assertNotEquals(30, cal.add(1, 2), "3�� �޶���Ѵ�. ");
	}
	@Test
	@DisplayName("���ϱ�2")
	void f3() {
		assertFalse("false�̾���Ѵ�.", cal.add(1, 2)>3);
	}
	
	@Test
	@DisplayName("nullüũ")
	void f4() {
		//assertNull("null�̾���Ѵ�.", cal.f5(11));
		assertNotNull("null�� �ƴϾ���Ѵ�.", cal.f5(11));
	}
	
	
	
	
}









