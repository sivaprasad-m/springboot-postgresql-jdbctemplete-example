package com.app.controller;


import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Employee;
import com.app.service.EmployeeService;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value="/createemployee")
	public ResponseEntity<String>  createEmployee(@RequestBody Employee employee){
		ResponseEntity<String> response=null;
		if(employee != null) {
			
			employeeService.saveEmployee(employee);
			response=new ResponseEntity<String>("Employee Created successfully",HttpStatus.CREATED);
			
		}else {
			 response=new ResponseEntity<String>("Employee Creation fail try try again",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
		
	}
	
	
	@SuppressWarnings("unchecked")
	@GetMapping(value="/getallemployees")
	public ResponseEntity<?> getEmployees(){
		ResponseEntity<?> response=null;
		
		List<Employee> employeesList=employeeService.getAllEmployees();	
		if(employeesList == null || employeesList.isEmpty()) {
			response=new ResponseEntity<String>("Employees Data Not Found",HttpStatus.BAD_REQUEST);
		}else {
				
			JSONObject jsonObject=new  JSONObject();
			JSONArray array=new JSONArray();
			array.add(employeesList);
			jsonObject.put("Employee_List", array);
			response=new ResponseEntity<JSONObject>(jsonObject,HttpStatus.OK);
		}
		
		return response;
		
	}
	
	@GetMapping("/getemployee/{employeeId}")
	public ResponseEntity<?> getEmployeerById(@PathVariable Integer employeeId){
		
		 ResponseEntity<?> resp=null;
		if(employeeId!=null ) {
			Employee employee=employeeService.getEmployeeById(employeeId);
			resp=new ResponseEntity<Employee>(employee,HttpStatus.OK);
		}else {
			resp=new ResponseEntity<String>("USER NOT FOUND",HttpStatus.BAD_REQUEST);
		}
		
		return resp;
	}
	@PutMapping("updateemployee")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
		Integer id=employee.getEmployeeId();
		boolean exist=employeeService.isExsits(id);
		ResponseEntity<String> resp=null;
		if(exist) {
			employeeService.updateEmployee(employee);
			resp=new ResponseEntity<String>("USER UPDATED SUCESSFULLY",HttpStatus.OK);
		}else {
			resp=new ResponseEntity<String>("USER NOT EXISTS",HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	@DeleteMapping("/deleteemployee/{employeeId}")
	public ResponseEntity<String> removeUser(@PathVariable Integer employeeId){
		
		
		employeeService.deleteEmployee(employeeId);
		ResponseEntity< String> resp=new ResponseEntity<String>("USER DELETED SUCCESSFULLY",HttpStatus.OK);
		
		return resp;
		
	}
	

}
