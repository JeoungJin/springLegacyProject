package com.shinhan.spring.section1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinhan.spring.model.emp.EmpDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Service
public class EmpServiceMockito {
	
	@Autowired
	EmpRepositoryInterface empRepository;

	public EmpDTO f1() {
		EmpDTO emp = empRepository.findById(100);
		log.info(emp.toString());
		return emp;
	}

	public List<EmpDTO> f2() {
		List<EmpDTO> emplist = empRepository.findAll();
		log.info(emplist.size() + "°Ç");
		return emplist;
	}

	public void insertEmp(EmpDTO emp) {
		empRepository.insert(emp);
	}

	public void updateEmp(EmpDTO emp) {
		empRepository.update(emp);
	}

	public void deleteEmp(int empId) {
		empRepository.delete(empId);
	}

}
