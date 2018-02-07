package com.spring.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.model.Employee;



/**
 * Defines DAO operations for the contact model.
 */
public interface ContactDAO {
	public Page<Employee> findAll(Pageable pageable);
	public List<Employee> get(String letter);
	public List<Employee> getAll(String name);
	public boolean create(String name,int salary,String dept);	
	public boolean delete(int contactId);
	public boolean update(int id,String name,int salary,String dept);	
}

