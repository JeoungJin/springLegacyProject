package com.shinhan.spring.model.job;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JobDTO {
    private String jobId;       // Job ID
    private String jobTitle;    // Job Title
    private int minSalary;      // Minimum Salary
    private int maxSalary;      // Maximum Salary
 
}
