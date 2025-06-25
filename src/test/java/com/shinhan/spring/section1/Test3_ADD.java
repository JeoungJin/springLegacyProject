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
	@DisplayName("�迭")
	void f1() {
		int[] arr1 = {1,2,3,4, 6};
		int[] arr2 = {1,2,3,4, 6};		
		assertArrayEquals(arr1, arr2, "�迭�� �����ؾ��Ѵ�.");		
	}
	
	@Test
	@DisplayName("����Ʈ1")
	void f2() {
		List<String> expectList = Arrays.asList("A","B","C");
		List<String> actualList = Arrays.asList("A","B","C" );
		
		assertIterableEquals(expectList, actualList, "List�� �����ؾ��Ѵ�.");
	}
	
	@Test
	@Disabled
	@DisplayName("����Ʈ2")
	void f3() {
		List<String> expectList = Arrays.asList("A","B","C");
		List<String> actualList = Arrays.asList("A","B","C");
		
		assertIterableEquals(expectList, actualList, "List�� �����ؾ��Ѵ�.");
	}
	
	//���ܹ߻� test
	
	@Test
	@DisplayName("����test")
	void f4() {
		
		Exception ex =  assertThrows(ArithmeticException.class, ()->{
			int a = 10/0;
			System.out.println(a);
		});
		assertEquals("/ by zero", ex.getMessage());
		
	}
	
 
	@Test
	@DisplayName("�ð�����")
	void f5() {
		assertTimeout(Duration.ofMillis(500), ()->{
			Thread.sleep(60);
		});
	}
	
 
	@Test
	@DisplayName("�������� Assertion")
	void f6() {
		assertAll(
				()->assertEquals(4,  1+3),
				()->assertEquals(40,  10+30),
				()->assertEquals(400,  100+300),				
				()->assertNotNull("aa")	
				);
		
	}
	
	@Test
	@DisplayName("�����ȵ�")
	void f7() { 
		fail("������������...������ ����");
	}
	
	
}













