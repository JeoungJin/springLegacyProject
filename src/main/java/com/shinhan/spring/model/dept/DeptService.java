package com.shinhan.spring.model.dept;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DeptService {

	@Autowired
	@Qualifier("deptDAOMybatis")
	DeptDAOInterface deptDAO;

	public List<DeptDTO> selectAll() {
		List<DeptDTO> deptlist = deptDAO.selectAll();

		return deptlist;
	}

	// 2.Select(Read)..
	public DeptDTO selectById(int deptid) {
		DeptDTO dept = deptDAO.selectById(deptid);

		return dept;
	}

	// 3.Inert
	public int insertDept(DeptDTO dept) {
		int result = deptDAO.insertDept(dept);

		return result;
	}

	// 4.Update
	public int updateDept(DeptDTO dept) {
		int result = deptDAO.updateDept(dept);
		return result;
	}

	// 5.Delete
	public int deleteDept(int deptid) {
		int result = deptDAO.deleteDept(deptid);
		return result;
	}

	public List<DeptDTO> selectAlldeptWithemp() {
		return deptDAO.selectAlldeptWithemp();
	}

}
