package com.spring.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Employee;

/**
 * An implementation of the ContactDAO interface.
 */
@Transactional
public class ContactDAOImpl implements ContactDAO {
			Logger logger = Logger.getLogger(ContactDAOImpl.class);
	private JdbcTemplate jdbcTemplate;
	private String info="check database connections Url,username,password";
	private String info1="check the sql query code";
	private String  emf="Eclipselink_JPA";
	public ContactDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAll(String name) {
					logger.info("Actual operation of getAll from database");
					logger.error(info);
					logger.error(info1);
		String sql = "SELECT * FROM employee order by "+ name;
		List<Employee> list = new ArrayList<>();
		List<Map<String, Object>> rows=jdbcTemplate.queryForList(sql);
		for (Map<String, Object> row : rows) {
			Employee customer = new Employee();
			
			String intValue=row.get("id").toString();
			customer.setId(Integer.parseInt(intValue));
			customer.setName((String)row.get("name"));
			intValue=row.get("salary").toString();
			customer.setSalary(Integer.parseInt(intValue));
			customer.setDept((String)row.get("dept"));
			list.add(customer);
		}
		return list;
	}
	@Override
	public List<Employee> get(String letter) {
				logger.info("Actual operation of search from database");
				logger.error(info);
				logger.error(info1);

		String sql = "SELECT * FROM employee WHERE upper(name) like upper('"+letter+"%')"; 
		List<Employee> listCustomer = new ArrayList<>();
		List<Map<String, Object>> rows=jdbcTemplate.queryForList(sql);
		for (Map<String, Object> row : rows) {
			Employee customer = new Employee();
			String intValue=row.get("id").toString();
			customer.setId(Integer.parseInt(intValue));
			customer.setName((String)row.get("name"));
			intValue=row.get("salary").toString();
			customer.setSalary(Integer.parseInt(intValue));
			customer.setDept((String)row.get("dept"));
			listCustomer.add(customer);
		}
		return listCustomer;
	}
	
	
	@PersistenceContext	
	@Override
	public boolean create(final String name,final int salary,final String dept) {
					logger.info("Actual operation of create from database");
					logger.error(info);
					logger.error(info1);
					
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( emf );
		      
		EntityManager entitymanager = emfactory.createEntityManager( );
				  entitymanager.getTransaction( ).begin( );	
				  Employee employee = new Employee( );				  
				  employee.setName(name);
				  employee.setDept(dept);
				  employee.setSalary(salary);
				  entitymanager.persist( employee);
			      entitymanager.getTransaction( ).commit( );
			      entitymanager.close( );
			      emfactory.close( );
				return false;
				
				
}

	@Override
	public boolean delete(final int id) {
		
						logger.info("Actual operation of delete from database");
						logger.error(info);
						logger.error(info1);
						
						EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( emf );
					      EntityManager entitymanager = emfactory.createEntityManager( );
					      entitymanager.getTransaction( ).begin( );
					      Employee employee = entitymanager.find( Employee.class, id);
					      entitymanager.remove( employee );
					      entitymanager.getTransaction( ).commit( );
					      entitymanager.close( );
					      emfactory.close( );
						return false;
		
	}
	@Override
	public boolean update(final int id,final String name,final int salary,final String dept) {
					logger.info("Actual operation of update from database");
					logger.error(info);
					logger.error(info1);
					EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( emf );
				      
				      EntityManager entitymanager = emfactory.createEntityManager( );
				      entitymanager.getTransaction( ).begin( );
				      Employee employee = entitymanager.find( Employee.class, id );
				      
				      employee.setName(name);
					  employee.setDept(dept);
					  employee.setSalary(salary);
					  entitymanager.getTransaction( ).commit( );
					  entitymanager.close();
				      emfactory.close();
				      
					return false;
					
									

}

}