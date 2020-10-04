package com.app.dao;

import java.util.List;
import java.util.Optional;

import com.app.model.Employee;

public interface EmployeeDao {
	
	public void addEmployee(Employee employee);
	public List<Employee> getEmployees(); 
	public Employee findEmployeeById(int employeeId);
	public boolean existsById(Integer id);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(Integer employeeId );

}
