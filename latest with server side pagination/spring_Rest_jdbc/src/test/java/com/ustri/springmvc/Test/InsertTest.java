package com.ustri.springmvc.Test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.spring.config.MvcConfiguration;
import com.spring.dao.ContactDAO;
import com.spring.dao.ContactDAOImpl;
import com.spring.model.Employee;




public class InsertTest {

	
	
	@Mock MvcConfiguration mvc;
	@Mock ContactDAO imp;
	
	
	@Before
    public void setUp() {
		mvc=new MvcConfiguration();
		 imp=new ContactDAOImpl(mvc.getDataSource());
    }
	@After
    public void tearDown() {
        mvc = null;
        imp = null;
               
    }
	
					Employee c=new Employee();
	@Test
	   public void create() {
	
		boolean status=imp.create("mason", 9898, "Army");
		assertEquals(false,status);
		
	}

}
