package com.shinhan.spring.section1;

import java.util.List;

import com.shinhan.spring.model.emp.EmpDTO;

//Mockito 
public interface EmpRepositoryInterface {
   public EmpDTO findById(int empid);
   public List<EmpDTO> findAll();
   public void insert(EmpDTO emp);
   public void update(EmpDTO emp);
   public void delete(int empid);
}