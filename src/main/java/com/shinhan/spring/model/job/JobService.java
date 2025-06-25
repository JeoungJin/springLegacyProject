package com.shinhan.spring.model.job;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * JobDAO ?Å¥?ûò?ä§?äî Jobs ?Öå?ù¥Î∏îÏóê ???ïú ?ç∞?ù¥?Ñ∞Î≤†Ïù¥?ä§ ?ûë?óÖ?ùÑ ?àò?ñâ?ï©?ãà?ã§.
 */

@Service
public class JobService {

	@Autowired
	JobDAO jobDAO;
	
	
    /**
     * Î™®Îì† Job ?ç∞?ù¥?Ñ∞Î•? Ï°∞Ìöå?ï©?ãà?ã§.
     * 
     * @return JobDTO Î¶¨Ïä§?ä∏
     */
    public List<JobDTO> getAllJobs() {
         
        return jobDAO.getAllJobs();
    }

    /**
     * ?ÉàÎ°úÏö¥ Job ?ç∞?ù¥?Ñ∞Î•? Ï∂îÍ??ï©?ãà?ã§.
     * 
     * @param job JobDTO Í∞ùÏ≤¥
     * @return ?Ñ±Í≥? ?ó¨Î∂?
     */
    public boolean addJob(JobDTO job) {
         
        return jobDAO.addJob(job);
    }

    /**
     * Í∏∞Ï°¥ Job ?ç∞?ù¥?Ñ∞Î•? ?àò?†ï?ï©?ãà?ã§.
     * 
     * @param job JobDTO Í∞ùÏ≤¥
     * @return ?Ñ±Í≥? ?ó¨Î∂?
     */
    public boolean updateJob(JobDTO job) {
         
        return jobDAO.updateJob(job);
    }

    /**
     * Job ?ç∞?ù¥?Ñ∞Î•? ?Ç≠?†ú?ï©?ãà?ã§.
     * 
     * @param jobId Job ID
     * @return ?Ñ±Í≥? ?ó¨Î∂?
     */
    public boolean deleteJob(String jobId) {
         
        return jobDAO.deleteJob(jobId);
    }
}






