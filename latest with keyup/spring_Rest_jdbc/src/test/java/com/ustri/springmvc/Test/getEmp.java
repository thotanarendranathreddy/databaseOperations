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


public class getEmp {
	
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
		
		@Test  public void get() {
			int i=1;
			List<Employee> status=imp.get("Nare");
			
			while(i<=2){
			for(Employee cust:status){						
			assertEquals("navy",cust.getName());
			i++;
			}
			}
		}
}
