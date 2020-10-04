package com.app.dao;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.app.model.Employee;
import com.app.rowmapper.EmployeeRowMapper;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	

	
		public void addEmployee(Employee employee) {
				
				if(employee!=null) {
					String addEmployee_sql = "INSERT INTO employee_details (employee_firstname,employee_lastname, employee_email,company_name,"
                         	+ "employee_salary,employee_address,experience,department ,mobile_number)"
                            + " VALUES (:employeeFirstName, :employeeLastName, :employeeEmail, :companyName, :employeeSalary,"
                            + " :employeeAddress, :experience, :depertment, :mobileNumber)";

	     KeyHolder holder=new GeneratedKeyHolder() ;
		SqlParameterSource param = new MapSqlParameterSource()
				          
							.addValue("employeeFirstName", employee.getEmployeeFirstName())
							.addValue("employeeLastName", employee.getEmployeeLastName())
							.addValue("employeeEmail", employee.getEmployeeEmail())
							.addValue("companyName", employee.getCompanyName())
							.addValue("employeeSalary", employee.getEmployeeSalary())
							.addValue("employeeAddress", employee.getEmployeeAddress())
							.addValue("experience", employee.getExperience())
							.addValue("depertment", employee.getDepartment())
							.addValue("mobileNumber", employee.getMobileNumber());
							
							
							        template.update(addEmployee_sql ,param,holder);
							}
	}



		public List<Employee> getEmployees()  {
		
			String sql="select * from employee_details";
			List<Employee> employee=template.query(sql, new EmployeeRowMapper()); 

				return employee;
			
		}
		@Override
		 public Employee findEmployeeById(int employeeId) {
		  String query = "SELECT * FROM employee_details WHERE employee_Id = ?";
		 
		  Employee employee = jdbcTemplate.queryForObject(query, new EmployeeRowMapper(), employeeId);
		  
		  return employee;
		 }




		
		public boolean existsById(Integer id) {
		    return jdbcTemplate.queryForObject(
		        "SELECT EXISTS(SELECT 1 FROM employee_details where employee_Id=?)", Boolean.class, id);
		}


		public void updateEmployee(Employee employee){
			String sql="update employee_details set employee_firstname=:employeeFirstName,employee_lastname=:employeeLastName,"
					+ "employee_email=:employeeEmail,company_name=:companyName,employee_salary=:employeeSalary,"
					+ "employee_address= :employeeAddress,experience= :experience,department= :department,mobile_number= :mobileNumber "
					+ " where employee_Id= :employeeId";
					
			     KeyHolder holder=new GeneratedKeyHolder() ;
			    SqlParameterSource param = new MapSqlParameterSource()
			    		    .addValue("employeeId", employee.getEmployeeId())
							.addValue("employeeFirstName", employee.getEmployeeFirstName())
							.addValue("employeeLastName", employee.getEmployeeLastName())
							.addValue("employeeEmail", employee.getEmployeeEmail())
							.addValue("companyName", employee.getCompanyName())
							.addValue("employeeSalary", employee.getEmployeeSalary())
							.addValue("employeeAddress", employee.getEmployeeAddress())
							.addValue("experience", employee.getExperience())
							.addValue("department", employee.getDepartment())
							.addValue("mobileNumber", employee.getMobileNumber());
							
								
								        template.update(sql ,param,holder);
	}
		
		
		
			    
			
		@Override
		public void deleteEmployee(Integer employeeId) {
			
			String sql="DELETE FROM employee_details WHERE employee_Id= ?";
		    jdbcTemplate.update(sql,employeeId);
		}
					

}
