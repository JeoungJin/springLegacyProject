package com.shinhan.spring.model.job;

 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

 

@Repository
public class JobDAO {

	@Autowired
	@Qualifier("dataSource2") 
	DataSource ds;
	
	
    
    public List<JobDTO> getAllJobs() {
        List<JobDTO> jobs = new ArrayList<>();
        String query = "SELECT * FROM jobs";

        try (Connection conn = ds.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                JobDTO job = new JobDTO();
                job.setJobId(rs.getString("job_id"));
                job.setJobTitle(rs.getString("job_title"));
                job.setMinSalary(rs.getInt("min_salary"));
                job.setMaxSalary(rs.getInt("max_salary"));
                jobs.add(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobs;
    }

    
    public boolean addJob(JobDTO job) {
        String query = "INSERT INTO jobs (job_id, job_title, min_salary, max_salary) VALUES (?, ?, ?, ?)";

        try (Connection conn = ds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, job.getJobId());
            pstmt.setString(2, job.getJobTitle());
            pstmt.setInt(3, job.getMinSalary());
            pstmt.setInt(4, job.getMaxSalary());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    
    public boolean updateJob(JobDTO job) {
        String query = "UPDATE jobs SET job_title = ?, min_salary = ?, max_salary = ? WHERE job_id = ?";

        try (Connection conn = ds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, job.getJobTitle());
            pstmt.setInt(2, job.getMinSalary());
            pstmt.setInt(3, job.getMaxSalary());
            pstmt.setString(4, job.getJobId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

     
    public boolean deleteJob(String jobId) {
        String query = "DELETE FROM jobs WHERE job_id = ?";

        try (Connection conn = ds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, jobId);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
