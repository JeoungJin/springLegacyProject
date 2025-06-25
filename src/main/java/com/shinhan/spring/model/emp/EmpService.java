package com.shinhan.spring.model.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

 
@Service("empService")
public class EmpService {
 	@Autowired
	@Qualifier("empMybatis")
 	EmpDAOInterface empDAO ;
	
	public EmpDTO execute_sp(int empid) {
		return empDAO.execute_sp(empid);
	}
	public int empUpdate(EmpDTO emp) {
		return empDAO.empUpdate(emp);
	}
	public int empInsert(EmpDTO emp) {
		return empDAO.empInsert(emp);
	}
	public int empDeleteById(int empid) {
		return empDAO.empDeleteById(empid);
	}
	public List<EmpDTO> selectByJobAndDept(String job, int dept) {
		return empDAO.selectByJobAndDept(job, dept);
	}
	public List<EmpDTO> selectByJob(String job) {
		return empDAO.selectByJob(job);
	}
	public List<EmpDTO> selectByDept(int deptid) {
		return empDAO.selectByDept(deptid);
	}
	public EmpDTO selectById(int empid) {
		return empDAO.selectById(empid);
	}
	public List<EmpDTO> selectAll() {
		//......
		return empDAO.selectAll();
	}
	public List<EmpDTO> selectByCondition
	          (Integer[] deptid, String jobid, int salary, String hdate, String date_check) {
		// TODO Auto-generated method stub
		return empDAO.selectByCondition(deptid,jobid,salary,hdate,date_check);
	}
}












