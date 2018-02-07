package com.ustri.springmvc.Test;

import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.spring.config.MvcConfiguration;
import com.spring.controller.HomeController;
import com.spring.dao.ContactDAO;
import com.spring.dao.ContactDAOImpl;

public class Contupdate {

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
		JSONObject emp = new JSONObject();
		emp.put("id", 1352);
		emp.put("name","Narendranath Reddy" );
		emp.put("salary",445566);
		emp.put("dept","A");
		String status=hc.update(emp.toString());
		assertEquals(status,status);
		
		
		JSONObject emp1 = new JSONObject();
		
		emp1.put("name","Narendranath Reddy" );
		emp1.put("salary",445566);
		emp1.put("dept","A");
		String status1=hc.update(emp1.toString());
		assertEquals(status1,status1);
	}
	
	
}
