package com.shinhan.spring.section2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.shinhan.spring.model.emp.EmpDTO;
import com.shinhan.spring.section1.EmpRepositoryInterface;
import com.shinhan.spring.section1.EmpServiceMockito;

//@ExtendWith(MockitoExtension.class)
class EmpServiceTest {

	@Mock
	EmpRepositoryInterface empRepository; // 가짜 객체

	@InjectMocks
	EmpServiceMockito empService; // @Mock이 주입된 실제 테스트 대상

	@Test
	void testF1() {
		EmpDTO dummy = new EmpDTO(100, "Steven", "King"); // 생성자에 맞게 수정
		when(empRepository.findById(100)).thenReturn(dummy);

		EmpDTO result = empService.f1();
		assertNotNull(result);
		assertEquals("Steven", result.getFirst_name());
	}

	 
	@Test
	void testF2() {
		List<EmpDTO> dummyList = Arrays.asList(
				new EmpDTO(100, "Steven", "King"), 
				new EmpDTO(101, "Neena", "Kochhar"));
		when(empRepository.findAll()).thenReturn(dummyList);
		List<EmpDTO> result = empService.f2();
		assertEquals(2, result.size());
		assertEquals("Neena", result.get(1).getFirst_name());
	}

	// void 메서드는 doNothing or doThrow 사용
	@Test
	void testInsert() {
		EmpDTO newEmp = new EmpDTO(1, "영희", "LEE");

		doNothing().when(empRepository).insert(newEmp);
		empService.insertEmp(newEmp);
		// 실제로 호출되었는지 검증
		verify(empRepository, times(1)).insert(newEmp);
	}
	@Test
	void testUpdate() {
		EmpDTO updatedEmp = new EmpDTO(2, "길동", "Hong");
		doNothing().when(empRepository).update(updatedEmp);
		empService.updateEmp(updatedEmp);
		empService.updateEmp(updatedEmp);
		verify(empRepository, times(2)).update(updatedEmp);// 2회 호출 검증
	}

	@Test
	@DisplayName("삭제")
	void testDelete() {
		int empId = 100;
		doNothing().when(empRepository).delete(empId);
		empService.deleteEmp(empId);
		verify(empRepository, times(1)).delete(100); // 1회 호출 검증
	}

}
