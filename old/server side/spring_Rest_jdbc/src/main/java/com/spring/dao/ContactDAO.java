package com.spring.dao;

import java.util.List;

import com.spring.model.Customer;



/**
 * Defines DAO operations for the contact model.
 */
public interface ContactDAO {
	
	public List<Customer> get(int contactId);
	public List<Customer> getAll(String name);
	public boolean create(int id,String name,int salary,String dept);	
	public boolean delete(int contactId);
	public boolean update(int id,String name,int salary,String dept);	
}
