package com.ustri.springmvc_junitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.spring.config.MvcConfiguration;
import com.spring.dao.ContactDAO;
import com.spring.dao.ContactDAOImpl;

public class DeleteTest {

	
	MvcConfiguration mvc=new MvcConfiguration();
	ContactDAO imp=new ContactDAOImpl(mvc.getDataSource());
	@Test
	   public void delete() {
	
		boolean status=imp.delete(2);
		assertEquals(false,status);
	}
}
