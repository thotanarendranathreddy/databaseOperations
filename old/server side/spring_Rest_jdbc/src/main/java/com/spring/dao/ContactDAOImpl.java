package com.spring.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import com.spring.model.Customer;

/**
 * An implementation of the ContactDAO interface.
 */
public class ContactDAOImpl implements ContactDAO {
	private Logger logger = Logger.getLogger(ContactDAOImpl.class);
	private JdbcTemplate jdbcTemplate;
	private String info="check database connections Url,username,password";
	private String info1="check the sql query code";
	
	public ContactDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Customer> getAll(String name) {
					logger.info("Actual operation of getAll from database");
					logger.error(info);
					logger.error(info1);
		String sql = "SELECT * FROM employee order by "+ name;
		List<Customer> list = new ArrayList<>();
		List<Map<String, Object>> rows=jdbcTemplate.queryForList(sql);
		for (Map<String, Object> row : rows) {
			Customer customer = new Customer();
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
	public List<Customer> get(int customerId) {
				logger.info("Actual operation of search from database");
				logger.error(info);
				logger.error(info1);

		String sql = "SELECT * FROM employee WHERE id=" + customerId;
		List<Customer> listCustomer = new ArrayList<>();
		List<Map<String, Object>> rows=jdbcTemplate.queryForList(sql);
		for (Map<String, Object> row : rows) {
			Customer customer = new Customer();
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
	
	@Override
	public boolean create(final int id,final String name,final int salary,final String dept) {
					logger.info("Actual operation of create from database");
					logger.error(info);
					logger.error(info1);
		String query = "insert into employee values(?,?,?,?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException{

				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setInt(3, salary);
				ps.setString(4, dept);
				return ps.execute();

			}
		}); 

}

	@Override
	public boolean delete(final int id) {
		
						logger.info("Actual operation of delete from database");
						logger.error(info);
						logger.error(info1);
		String sql = "DELETE FROM employee WHERE id=?";
		return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException{

				ps.setInt(1, id);
				return ps.execute();

			}
		}); 
	}
	@Override
	public boolean update(final int id,final String name,final int salary,final String dept) {
					logger.info("Actual operation of update from database");
					logger.error(info);
					logger.error(info1);
		String query = "UPDATE employee SET name=?,salary=?,dept=? WHERE id=?";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException{			
				ps.setString(1, name);
				ps.setInt(2, salary);
				ps.setString(3, dept);
				ps.setInt(4, id);
				return ps.execute();

			}
		}); 

}

}