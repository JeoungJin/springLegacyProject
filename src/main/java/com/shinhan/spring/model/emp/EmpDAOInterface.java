package com.shinhan.spring.model.emp;

import java.util.List;

public interface EmpDAOInterface  {
	public EmpDTO execute_sp(int empid) ;
	public int empUpdate(EmpDTO emp) ;
	public int empUpdate2(EmpDTO emp);
	public int empInsert(EmpDTO emp);
	public int empDeleteById(int empid) ;
	public List<EmpDTO> selectByCondition(Integer[] arr, String jobid, int salary, String hdate);
	public List<EmpDTO> selectByCondition(Integer[] arr, String jobid, int salary, String hdate, String date_check);
	public List<EmpDTO> selectByJobAndDept(String job, int dept);
	public List<EmpDTO> selectByJob(String job);
	public List<EmpDTO> selectByDept(int deptid) ;
	public EmpDTO selectById(int empid) ;
	public List<EmpDTO> selectAll();
}
