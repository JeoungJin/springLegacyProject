package com.shinhan.spring.model.job;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class JobService {

	@Autowired
	JobDAO jobDAO;
	
	
 
    public List<JobDTO> getAllJobs() {
         
        return jobDAO.getAllJobs();
    }

 
    public boolean addJob(JobDTO job) {
         
        return jobDAO.addJob(job);
    }

     
    public boolean updateJob(JobDTO job) {
         
        return jobDAO.updateJob(job);
    }

   
    public boolean deleteJob(String jobId) {
         
        return jobDAO.deleteJob(jobId);
    }
}






