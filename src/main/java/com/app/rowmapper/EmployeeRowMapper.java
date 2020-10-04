package com.app.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.app.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee=new Employee();
		employee.setEmployeeId(rs.getInt("employee_Id"));
		employee.setEmployeeFirstName(rs.getString("employee_firstname"));
		employee.setEmployeeLastName(rs.getString("employee_lastname"));
		employee.setEmployeeEmail(rs.getString("employee_Email"));
		employee.setCompanyName(rs.getString("company_Name"));
		employee.setEmployeeSalary(rs.getDouble("employee_Salary"));
		employee.setEmployeeAddress(rs.getString("employee_Address"));
		employee.setExperience(rs.getDouble("experience"));
		employee.setDepartment(rs.getString("department"));
		employee.setMobileNumber(rs.getLong("mobile_Number"));
		
		return employee;
	}

}
