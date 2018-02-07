package com.ustri.springmvc_junitTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.spring.config.MvcConfiguration;
import com.spring.dao.ContactDAO;
import com.spring.dao.ContactDAOImpl;
import com.spring.model.Customer;

public class getEmp {

	
	MvcConfiguration mvc=new MvcConfiguration();
	ContactDAO imp=new ContactDAOImpl(mvc.getDataSource());
		Customer c=new Customer();
		@Test
		   public void get() {
		
			List<Customer> status=imp.get(2);
			
			for(Customer cust:status){
				
			assertEquals("navy",cust.getName());
			}
		}
}
