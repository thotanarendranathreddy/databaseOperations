package com.spring.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.spring.dao.ContactDAO;
import com.spring.model.Employee;

/**
 * This controller routes accesses to the application to the appropriate
 * hanlder methods. 
 */
@RestController
public class HomeController {
	String sal="salary";
	String info="value is Timestamp coming from Angular2 via http request ";
	String info1="check json dependency is fine or any problem";
	private static final String STATUS="status";
	                    Logger logger = Logger.getLogger(HomeController.class);
	@Autowired
	private ContactDAO contactDAO;
	
	@RequestMapping(value = "/getAll/{name}/{value}", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Employee> getAll(@PathVariable String name) {
				logger.info("This is used to  get all employee details");
				logger.info(info);
			
		List<Employee> list ;
		list=contactDAO.getAll(name);
		return list;
	}
	@RequestMapping(value = "/getEmployee/{letter}/{value}", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Employee> getEmployee(@PathVariable String letter) {
				logger.info("This is used to search employee details");
				logger.info(info);		
		List<Employee> list;
		list=contactDAO.get(letter);
		return list;
	}
	
	@RequestMapping(value = "/create/{value}", method = RequestMethod.POST, headers = "Accept=application/json")
	public String create(@RequestBody String employee) {
				logger.info("This is used to create employee details");
				logger.info(info);
				logger.info(info1);
		JSONObject empObj = new JSONObject(employee);
		JSONObject jsonresponse1=new JSONObject();
		try{
		logger.info(empObj.getString("name"));
		logger.info(empObj.getInt(sal));
		logger.info(empObj.getString("dept"));
		Boolean status1= contactDAO.create(empObj.getString("name"),empObj.getInt(sal),empObj.getString("dept"));
		logger.info(status1);
					if(!status1){
			            jsonresponse1.put(STATUS, "Successfully inserted!!");
     
						     }}
						     catch(Exception e)
						     {
						            logger.info(e);
						            logger.error("unable to process the insertion: id must be unique!");
						            jsonresponse1.put(STATUS, "unable to process the insertion!!");
						     
						     }
						            return jsonresponse1.toString();

	} 
	
	@RequestMapping(value = "/delete/{id}/{value}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String delete(@PathVariable int id) {
		
		JSONObject jsonresponse2=new JSONObject();
		try{
				logger.info("This is used to  delete employee details");
				logger.info(info);		
		Boolean status2= contactDAO.delete(id);
		logger.info(status2);
						if(!status2){
				            jsonresponse2.put(STATUS, "Successfully Deleted!!");
				     
							     }}
							     catch(Exception e)
							     {
							            logger.info(e);
							            logger.error("unable to process the Deletion");
							            jsonresponse2.put(STATUS, "unable to process the Deletion!!");
							     
							     }
							            return jsonresponse2.toString();
	} 
	@RequestMapping(value = "/update/{value}", method = RequestMethod.POST, headers = "Accept=application/json")
	 public String update(@RequestBody String employee) {
				logger.info("This is used to update employee details");
				logger.info(info);
				logger.info(info1);
		JSONObject empObj = new JSONObject(employee);
		JSONObject jsonresponse3=new JSONObject();
		try{
		logger.info(empObj.getInt("id"));
		logger.info(empObj.getString("name"));
		logger.info(empObj.getInt(sal));
		logger.info(empObj.getString("dept"));
		Boolean status3= contactDAO.update(empObj.getInt("id"),empObj.getString("name"),empObj.getInt(sal),empObj.getString("dept"));
		logger.info(status3);
					if(!status3){
			            jsonresponse3.put(STATUS, "Successfully Updated!!");
			     
						     }}
						     catch(Exception e)
						     {
						            logger.info(e);
						            logger.error("unable to process the Updation");
						            jsonresponse3.put(STATUS, "unable to process the Updation!!");
						     
						     }
						            return jsonresponse3.toString();
							} 
	
	
	public void setOBj(ContactDAO contactDAO){
		
		this.contactDAO=contactDAO;
		
	}
	
	
}
