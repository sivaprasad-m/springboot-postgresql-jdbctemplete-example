package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.EmployeeDao;
import com.app.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	public void saveEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
		
	}

	public List<Employee> getAllEmployees() {
		
		return employeeDao.getEmployees();
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		Employee employee=employeeDao.findEmployeeById(employeeId);
		return employee;
	}

	@Override
	public boolean isExsits(Integer employeeId) {
		return employeeDao.existsById(employeeId);
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		employeeDao.deleteEmployee(employeeId);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
		
	}

	
	
	


}
