package com.shinhan.spring.model.emp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("empMybatis")
public class EmpDAOMybatis implements EmpDAOInterface {

	@Autowired
	SqlSession sqlSession;
	String namespace = "com.firstzone.emp.";

	@Override
	public EmpDTO execute_sp(int empid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int empUpdate(EmpDTO emp) {
		int result = sqlSession.update(namespace + "update", emp);
	 
		return result;
	}

	@Override
	public int empUpdate2(EmpDTO emp) {
		int result = sqlSession.update(namespace + "update", emp);
	 
		return result;
	}

	@Override
	public int empInsert(EmpDTO emp) {
		int result = sqlSession.delete(namespace + "insert", emp);
	 
		return result;
	}

	@Override
	public int empDeleteById(int empid) {
		int result = sqlSession.delete(namespace + "delete", empid);
		log.info(result+ "�� ������(Mybatis) ");
		return result;
	}

	//interface�� �����Ǿ������Ƿ� �ݵ�� �����Ѵ�..... 
	@Override
	public List<EmpDTO> selectByCondition(Integer[] arr, String jobid, int salary, 
			String hdate ) {
	   
		return null;
	}
	//����SQL�� ������ ���� ���� �Լ��� ������ 
	public List<EmpDTO> selectByCondition(Integer[] arr, String jobid, int salary, 
			String hdate, String date_check) {
	    EmpRequestDTO dto = EmpRequestDTO.builder()
	    		.deptid(arr)
	    		.jobid(jobid)
	    		.salary(salary)
	    		.hire_date(hdate)
	    		.date_check(date_check)
	    		.build();
	    List<EmpDTO> emplist = sqlSession.selectList(namespace + "selectByCondition", dto);
	    log.debug(emplist.size() + "����ȸ��(Mybatis)....debug ");
	    log.info(emplist.size() + "����ȸ��(Mybatis)....info ");	
		log.warn(emplist.size() + "����ȸ��(Mybatis)....warn ");
		return emplist;
	}
	
	@Override
	public List<EmpDTO> selectByJobAndDept(String job, int dept) {
	    Map<String, Object> mapData = new HashMap<>();
	    mapData.put("jobid", job);
	    mapData.put("deptid", dept);
		List<EmpDTO> emplist = sqlSession.selectList(namespace + "selectByJobAndDept", job);
		log.info(emplist.size() + "����ȸ��(Mybatis) ");
		return emplist;
	}

	@Override
	public List<EmpDTO> selectByJob(String job) {
		List<EmpDTO> emplist = sqlSession.selectList(namespace + "selectByJob", job);
		log.info(emplist.size() + "����ȸ��(Mybatis) ");
		return emplist;
	}

	@Override
	public List<EmpDTO> selectByDept(int deptid) {
		List<EmpDTO> emplist = sqlSession.selectList(namespace + "selectByDept", deptid);
		log.info(emplist.size() + "����ȸ��(Mybatis) ");
		return emplist;
	}

	@Override
	public EmpDTO selectById(int empid) {
		EmpDTO emp = sqlSession.selectOne(namespace + "selectById", empid);
		log.info(emp!=null?emp.toString():"0��" + " ��ȸ��(Mybatis) ");
		return emp;
	}

	@Override
	public List<EmpDTO> selectAll() {
		List<EmpDTO> emplist = sqlSession.selectList(namespace + "selectAll");

		log.info(emplist.size() + "����ȸ��(Mybatis) ");
		return emplist;
	}

}






