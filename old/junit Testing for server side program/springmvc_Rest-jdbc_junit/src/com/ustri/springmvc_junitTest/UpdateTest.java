package com.ustri.springmvc_junitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.spring.config.MvcConfiguration;
import com.spring.dao.ContactDAO;
import com.spring.dao.ContactDAOImpl;
import com.spring.model.Customer;

public class UpdateTest {

	
	MvcConfiguration mvc=new MvcConfiguration();
	ContactDAO imp=new ContactDAOImpl(mvc.getDataSource());
		Customer c=new Customer();
		@Test
		   public void create() {
		
			boolean status=imp.update(2, "navy", 656565, "Army");
			assertEquals(false,status);
		}
}
