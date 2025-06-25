package com.shinhan.spring.model.emp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder

@Data
public class EmpDeptFlatDTO {
	private Integer employee_id;    
	private String first_name;     
	private String last_name;      
	private String email;          
 
	private Integer department_id;    
	private String department_name;    

}


