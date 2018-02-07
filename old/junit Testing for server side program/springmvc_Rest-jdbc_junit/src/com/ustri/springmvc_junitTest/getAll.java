package com.ustri.springmvc_junitTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.spring.config.MvcConfiguration;
import com.spring.dao.ContactDAO;
import com.spring.dao.ContactDAOImpl;
import com.spring.model.Customer;

public class getAll {

	
	MvcConfiguration mvc=new MvcConfiguration();
	ContactDAO imp=new ContactDAOImpl(mvc.getDataSource());
		Customer c=new Customer();
		@Test
	public void getall() {
		    	int i=1;
			    String[] names=new String[10];
			    names[1]="Narendranath Reddy";
			    names[2]="navy";
			    names[3]="Alex";
			    names[4]="Mason";
			List<Customer> status=imp.getAll();
			while(i<=2){
			for(Customer cust:status){
			assertEquals(names[i],cust.getName());
			i++;
			}
			}
		}
}
