package com.shinhan.spring.model.dept;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

//서비스 :비지니스 로직을 수행한다. DB에 가는 업무는 DAO를 호출한다. 


@Service  //@Componet + 서비스역할
@Slf4j
public class DeptService {
	
	@Autowired  //타입이 같으면 Injection, 같은타입이 여러개있으면 이름으로 Injection
	@Qualifier("deptDAOMybatis")  //같은이름의 Bean을 Injection한다
	DeptDAOInterface deptDAO;

	public List<DeptDTO> selectAll() {
		List<DeptDTO> deptlist = deptDAO.selectAll();
		log.info("[롬복]DeptService에서 로그출력:" + deptlist.size() + "건");
		// System.out.println("DeptService에서 로그출력:" + deptlist.size() + "건");
		return deptlist;
	}

	// 2.Select(Read)..상세보기
	public DeptDTO selectById(int deptid) {
		DeptDTO dept = deptDAO.selectById(deptid);
		log.info("DeptService에서 로그출력:" + dept.toString());
		return dept;
	}

	// 3.Inert
	public int insertDept(DeptDTO dept) {
		int result = deptDAO.insertDept(dept);
		log.info("DeptService에서 로그출력:" + result + "건 insert");
		return result;
	}

	// 4.Update
	public int updateDept(DeptDTO dept) {
		int result = deptDAO.updateDept(dept);
		log.info("DeptService에서 로그출력:" + result + "건 update");
		return result;
	}

	// 5.Delete
	public int deleteDept(int deptid) {
		int result = deptDAO.deleteDept(deptid);
		log.info("DeptService에서 로그출력:" + result + "건 delete");
		return result;
	}
	
	public List<DeptDTO> selectAlldeptWithemp() {
		return deptDAO.selectAlldeptWithemp();
	}
	
	
	
}






