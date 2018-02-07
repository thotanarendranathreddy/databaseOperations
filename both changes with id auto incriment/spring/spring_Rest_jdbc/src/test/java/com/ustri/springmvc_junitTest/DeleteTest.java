package com.ustri.springmvc_junitTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.spring.config.MvcConfiguration;
import com.spring.dao.ContactDAO;
import com.spring.dao.ContactDAOImpl;

public class DeleteTest {

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

	@Test
	   public void delete() {
	
		boolean status=imp.delete(1802);
		assertEquals(false,status);
	}
}
