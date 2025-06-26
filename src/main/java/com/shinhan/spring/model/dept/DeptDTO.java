package com.shinhan.spring.model.dept;

import java.util.List;

import com.shinhan.spring.model.emp.EmpDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DeptDTO {
	private Integer department_id;    
	private String department_name;  
	private Integer manager_id;      
	private Integer location_id;      
	
	List<EmpDTO> empList;
	
}







