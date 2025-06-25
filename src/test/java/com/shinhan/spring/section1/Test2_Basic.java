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
	@DisplayName("더하기")
	void f1() {
		assertEquals(30, cal.add(10, 20), "30이어야합니다.");  
	}
	@Test
	@DisplayName("더하기2")
	void f2() {
		assertNotEquals(30, cal.add(1, 2), "3과 달라야한다. ");
	}
	@Test
	@DisplayName("더하기2")
	void f3() {
		assertFalse("false이어야한다.", cal.add(1, 2)>3);
	}
	
	@Test
	@DisplayName("null체크")
	void f4() {
		//assertNull("null이어야한다.", cal.f5(11));
		assertNotNull("null이 아니어야한다.", cal.f5(11));
	}
	
	
	
	
}









