package com.ustri.springmvc.Test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.spring.config.MvcConfiguration;
import com.spring.controller.HomeController;
import com.spring.dao.ContactDAO;
import com.spring.dao.ContactDAOImpl;

public class Contdelete {

	
	@Mock
	HomeController hc;
	@Mock MvcConfiguration mvc;
	@Mock ContactDAO imp;
	@Before
    public void setUp() {
		hc=new HomeController();
		mvc=new MvcConfiguration();
		imp=new ContactDAOImpl(mvc.getDataSource());
    }
	@After
    public void tearDown() {
        hc = null;
        mvc =null;
        imp=null;
    }
	@Test public void update() {
		hc.setOBj(imp);
		String status=hc.delete(27102);
		assertEquals(status,status);
		String status1=hc.delete(00);
		assertEquals(status1,status1);
	}
	
	
}
