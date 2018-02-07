package com.ustri.springmvc.Test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.spring.config.MvcConfiguration;
import com.spring.model.Employee;

public class pojoTest {
	@Mock MvcConfiguration mvc;
	@Mock Employee emp;
	
	
	@Before
    public void setUp() {
		mvc=new MvcConfiguration();
		 emp=new Employee();
    }
	@After
    public void tearDown() {
        mvc = null;
        emp = null;
               
    }

	
	
	
	@Test  public void fn() {
		Employee c=new Employee(6,"james",3300,"A");
		assertEquals(6,c.getId());
		assertEquals("james",c.getName());
		assertEquals(3300,c.getSalary());
		assertEquals("A",c.getDept());
	}
	@Test  public void fn1() {
		emp.setId(1);
		assertEquals(1,emp.getId());						
	}
	
	@Test  public void fn2() {
		emp.setSalary(23000);
		assertEquals(23000,emp.getSalary());						
	}
	@Test  public void fn3() {
		emp.setDept("Army");
		assertEquals("Army",emp.getDept());						
	}
	
}
