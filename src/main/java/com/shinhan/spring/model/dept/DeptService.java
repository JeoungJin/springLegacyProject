package com.shinhan.spring.model.dept;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

//���� :�����Ͻ� ������ �����Ѵ�. DB�� ���� ������ DAO�� ȣ���Ѵ�. 


@Service  //@Componet + ���񽺿���
@Slf4j
public class DeptService {
	
	@Autowired  //Ÿ���� ������ Injection, ����Ÿ���� ������������ �̸����� Injection
	@Qualifier("deptDAOMybatis")  //�����̸��� Bean�� Injection�Ѵ�
	DeptDAOInterface deptDAO;

	public List<DeptDTO> selectAll() {
		List<DeptDTO> deptlist = deptDAO.selectAll();
		log.info("[�Һ�]DeptService���� �α����:" + deptlist.size() + "��");
		// System.out.println("DeptService���� �α����:" + deptlist.size() + "��");
		return deptlist;
	}

	// 2.Select(Read)..�󼼺���
	public DeptDTO selectById(int deptid) {
		DeptDTO dept = deptDAO.selectById(deptid);
		log.info("DeptService���� �α����:" + dept.toString());
		return dept;
	}

	// 3.Inert
	public int insertDept(DeptDTO dept) {
		int result = deptDAO.insertDept(dept);
		log.info("DeptService���� �α����:" + result + "�� insert");
		return result;
	}

	// 4.Update
	public int updateDept(DeptDTO dept) {
		int result = deptDAO.updateDept(dept);
		log.info("DeptService���� �α����:" + result + "�� update");
		return result;
	}

	// 5.Delete
	public int deleteDept(int deptid) {
		int result = deptDAO.deleteDept(deptid);
		log.info("DeptService���� �α����:" + result + "�� delete");
		return result;
	}
	
	public List<DeptDTO> selectAlldeptWithemp() {
		return deptDAO.selectAlldeptWithemp();
	}
	
	
	
}






