package com.spring.dao;

import java.util.List;

import com.spring.model.Employee;



/**
 * Defines DAO operations for the contact model.
 */
public interface ContactDAO {
	
	public List<Employee> get(String letter);
	public List<Employee> getAll(String name);
	public boolean create(String name,int salary,String dept);	
	public boolean delete(int contactId);
	public boolean update(int id,String name,int salary,String dept);	
}

