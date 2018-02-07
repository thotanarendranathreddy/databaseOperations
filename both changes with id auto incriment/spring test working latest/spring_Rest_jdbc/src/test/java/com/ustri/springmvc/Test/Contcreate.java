package com.ustri.springmvc.Test;



import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.junit.Assert.assertEquals;
import com.spring.config.MvcConfiguration;
import com.spring.controller.HomeController;
import com.spring.dao.ContactDAO;
import com.spring.dao.ContactDAOImpl;

public class Contcreate {

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
	@Test public void create() {
		hc.setOBj(imp);
		JSONObject emp = new JSONObject();
		emp.put("name","mason" );
		emp.put("salary",445566);
		emp.put("dept","A");
		String status=hc.create(emp.toString());
		assertEquals(status,status);
		
		
		JSONObject emp1 = new JSONObject();
		
		emp1.put("salary",445566);
		emp1.put("dept","A");
		String status1=hc.create(emp1.toString());
		assertEquals(status1,status1);
		
	}
	
	
}
