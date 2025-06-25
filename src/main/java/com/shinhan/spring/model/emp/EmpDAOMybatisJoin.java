package com.shinhan.spring.model.emp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("empMybatisJoin")
public class EmpDAOMybatisJoin  {

	@Autowired
	SqlSession sqlSession;
	String namespace = "com.firstzone.deptemp.";

	public List<EmpDeptFlatDTO> selectAllJoinFlat() {
		List<EmpDeptFlatDTO> emplist = sqlSession.selectList(namespace + "selectAllJoinFlat");
		log.info(emplist.size() + "°ÇÁ¶È¸µÊ(Mybatis) ");
		return emplist;
	}

	public List<EmpDeptAssoDTO> selectAllJoinAsso() {
		List<EmpDeptAssoDTO> emplist = sqlSession.selectList(namespace + "selectAllJoinAsso");
		log.info(emplist.size() + "°ÇÁ¶È¸µÊ(Mybatis) ");
		return emplist;
	}
	
}









