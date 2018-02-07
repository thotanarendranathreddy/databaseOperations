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

public class Contgetemp {

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
	
	 @Test  public void get() {
     	 hc.setOBj(imp);;		  
		 int i=1;
			List<Employee> status=hc.getEmployee("Nare");
			
			while(i<=2){
			for(Employee cust:status){						
			assertEquals("navy",cust.getName());
			i++;
			}
			}
		 
     }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
