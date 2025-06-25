package com.shinhan.spring.model.job;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * JobDAO ?��?��?��?�� Jobs ?��?��블에 ???�� ?��?��?��베이?�� ?��?��?�� ?��?��?��?��?��.
 */

@Service
public class JobService {

	@Autowired
	JobDAO jobDAO;
	
	
    /**
     * 모든 Job ?��?��?���? 조회?��?��?��.
     * 
     * @return JobDTO 리스?��
     */
    public List<JobDTO> getAllJobs() {
         
        return jobDAO.getAllJobs();
    }

    /**
     * ?��로운 Job ?��?��?���? 추�??��?��?��.
     * 
     * @param job JobDTO 객체
     * @return ?���? ?���?
     */
    public boolean addJob(JobDTO job) {
         
        return jobDAO.addJob(job);
    }

    /**
     * 기존 Job ?��?��?���? ?��?��?��?��?��.
     * 
     * @param job JobDTO 객체
     * @return ?���? ?���?
     */
    public boolean updateJob(JobDTO job) {
         
        return jobDAO.updateJob(job);
    }

    /**
     * Job ?��?��?���? ?��?��?��?��?��.
     * 
     * @param jobId Job ID
     * @return ?���? ?���?
     */
    public boolean deleteJob(String jobId) {
         
        return jobDAO.deleteJob(jobId);
    }
}






