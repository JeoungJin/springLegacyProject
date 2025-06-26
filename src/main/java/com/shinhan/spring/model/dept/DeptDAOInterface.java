package com.shinhan.spring.model.dept;

import java.util.List;
import java.util.Map;
 
public interface DeptDAOInterface {
 	//1.Select(Read 
	public List<DeptDTO> selectAll() ;
	//2.Select(Read) 
	public DeptDTO selectById(int deptid) ;
	//3.Inert
	public int insertDept(DeptDTO dept);
	//4.Update
	public int updateDept(DeptDTO dept) ;
	//5.Delete
	public int deleteDept(int deptid);	
	
	public List<DeptDTO> selectAlldeptWithemp() ;
		
}






