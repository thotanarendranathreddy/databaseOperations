package com.ustri.springmvc.Test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.spring.config.MvcConfiguration;
import com.spring.dao.ContactDAO;
import com.spring.dao.ContactDAOImpl;
import com.spring.model.Employee;

public class getAll {

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
	public void getall() {
		    	int i=1;
			    String[] names=new String[10];
			    names[1]="A";
			    names[2]="A";
			    names[3]="A";
			    names[4]="A";
			String name = "name";
			List<Employee> status=imp.getAll(name);
			while(i<=2){
			for(Employee cust:status){
			assertEquals(names[i],cust.getDept());
			i++;
			}
			}
		}
}
