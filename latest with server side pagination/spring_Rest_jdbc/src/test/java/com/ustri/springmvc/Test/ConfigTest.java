package com.ustri.springmvc.Test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.spring.config.MvcConfiguration;
import com.spring.dao.ContactDAO;
import org.springframework.web.servlet.ViewResolver;


public class ConfigTest {

	@Mock MvcConfiguration mvc;
	
	
	
	@Before
    public void setUp() {
		mvc=new MvcConfiguration();
		
    }
	@After
    public void tearDown() {
        mvc = null;                      
    }	
	
	
	@Test
	   public void con1() {
		ContactDAO imp=	mvc.getContactDAO();	
		assertEquals(imp,imp);		
         }
	
	
	@Test
	public void con2(){
	ViewResolver resolver = mvc.getViewResolver();
	assertEquals(resolver,resolver);
	}
}
