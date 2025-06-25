package com.shinhan.spring.section1;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test3_ADD {

	@Test
	@DisplayName("배열")
	void f1() {
		int[] arr1 = {1,2,3,4, 6};
		int[] arr2 = {1,2,3,4, 6};		
		assertArrayEquals(arr1, arr2, "배열이 동일해야한다.");		
	}
	
	@Test
	@DisplayName("리스트1")
	void f2() {
		List<String> expectList = Arrays.asList("A","B","C");
		List<String> actualList = Arrays.asList("A","B","C" );
		
		assertIterableEquals(expectList, actualList, "List가 동일해야한다.");
	}
	
	@Test
	@Disabled
	@DisplayName("리스트2")
	void f3() {
		List<String> expectList = Arrays.asList("A","B","C");
		List<String> actualList = Arrays.asList("A","B","C");
		
		assertIterableEquals(expectList, actualList, "List가 동일해야한다.");
	}
	
	//예외발생 test
	
	@Test
	@DisplayName("예외test")
	void f4() {
		
		Exception ex =  assertThrows(ArithmeticException.class, ()->{
			int a = 10/0;
			System.out.println(a);
		});
		assertEquals("/ by zero", ex.getMessage());
		
	}
	
 
	@Test
	@DisplayName("시간제약")
	void f5() {
		assertTimeout(Duration.ofMillis(500), ()->{
			Thread.sleep(60);
		});
	}
	
 
	@Test
	@DisplayName("여러개의 Assertion")
	void f6() {
		assertAll(
				()->assertEquals(4,  1+3),
				()->assertEquals(40,  10+30),
				()->assertEquals(400,  100+300),				
				()->assertNotNull("aa")	
				);
		
	}
	
	@Test
	@DisplayName("구현안됨")
	void f7() { 
		fail("구현되지않음...무조건 실패");
	}
	
	
}













