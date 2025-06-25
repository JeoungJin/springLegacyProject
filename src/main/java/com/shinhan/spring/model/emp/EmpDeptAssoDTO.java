package com.shinhan.spring.model.emp;

import com.shinhan.spring.model.dept.DeptDTO;
import com.shinhan.spring.model.job.JobDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder

@Data
public class EmpDeptAssoDTO {
	private Integer employee_id;    
	private String first_name;     
	private String last_name;      
	private String email;          
 
	//n:1  association
	DeptDTO deptDTO;
	
	//n:1  association
	JobDTO jobDTO;
 
}


