package com.ustri.springmvc.Test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.spring.config.MvcConfiguration;
import com.spring.controller.HomeController;
import com.spring.dao.ContactDAO;
import com.spring.dao.ContactDAOImpl;
import com.spring.model.Employee;

public class getAllCont {

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

	
		
		
		@Test  public void getAll() {
			hc.setOBj(imp);
			int i=1;
		    String[] names=new String[10];
		    names[1]="A";
		    names[2]="A";
		    names[3]="A";
		    names[4]="A";
		String name = "name";
		List<Employee> status=hc.getAll(name);
		while(i<=4){
		for(Employee cust:status){
		assertEquals(cust.getDept(),cust.getDept());		
		i++;
		}
		}
		
		}
	
	
	
	
	
}
