package com.app.service;

import java.util.List;

import com.app.model.Employee;

public interface EmployeeService {
	
	public void saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(Integer employeeId);
	public boolean isExsits(Integer employeeId);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(Integer employeeId);

}
