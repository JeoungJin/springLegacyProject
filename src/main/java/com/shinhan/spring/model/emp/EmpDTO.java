package com.shinhan.spring.model.emp;

import java.sql.Date;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EmpDTO {
	private Integer employee_id;    
	private String first_name;     
	private String last_name;      
	private String email;          
	private String phone_number;   
	
	//JSON 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date hire_date;     
	//JSON 
	@JsonProperty("job_id")
	private String job_id;
	
 
	private Double salary;         
	private Double commission_pct; 
	private Integer manager_id;     
	private Integer department_id;
	public EmpDTO(Integer employee_id, String first_name, String last_name) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
	}
	
	
	 
	
	
	 
	
	
	
}


