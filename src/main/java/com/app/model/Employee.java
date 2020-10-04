package com.app.model;

import org.springframework.jdbc.support.KeyHolder;

public class Employee {
	
	private Integer employeeId;
	private String employeeFirstName;
	private String employeeLastName;
    private String employeeEmail;
    private String companyName;
	private double employeeSalary;
	private String employeeAddress;
	private double experience;
	private String department;
	private long mobileNumber;
	public Employee() {
		super();
	}
	public Employee(Integer employeeId, String employeeFirstName, String employeeLastName, String employeeEmail,
			String companyName, double employeeSalary, String employeeAddress, double experience, String department,
			long mobileNumber) {
		super();
		this.employeeId = employeeId;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.employeeEmail = employeeEmail;
		this.companyName = companyName;
		this.employeeSalary = employeeSalary;
		this.employeeAddress = employeeAddress;
		this.experience = experience;
		this.department = department;
		this.mobileNumber = mobileNumber;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
	public String getEmployeeLastName() {
		return employeeLastName;
	}
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public double getExperience() {
		return experience;
	}
	public void setExperience(double experience) {
		this.experience = experience;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeFirstName=" + employeeFirstName + ", employeeLastName="
				+ employeeLastName + ", employeeEmail=" + employeeEmail + ", companyName=" + companyName
				+ ", employeeSalary=" + employeeSalary + ", employeeAddress=" + employeeAddress + ", experience="
				+ experience + ", department=" + department + ", mobileNumber=" + mobileNumber + "]";
	}
	
	

}
