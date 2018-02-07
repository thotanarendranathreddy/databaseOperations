package com.ustri.springmvc_junitTest;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.spring.config.MvcConfiguration;
import com.spring.dao.ContactDAO;
import com.spring.dao.ContactDAOImpl;
import com.spring.model.Employee;




@RunWith(MockitoJUnitRunner.class)
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
		
			List<Employee> status=imp.get(1652);
			
			for(Employee cust:status){
				
			assertEquals("navy",cust.getName());
			}
		}
}
