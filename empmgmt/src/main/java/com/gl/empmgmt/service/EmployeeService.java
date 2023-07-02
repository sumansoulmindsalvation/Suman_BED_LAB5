package com.gl.empmgmt.service;

import java.util.List;

import com.gl.empmgmt.entity.Employee;


public interface EmployeeService {
	
	public List<Employee> getAlEmployee();
	public void createEmployee(Employee emp);
	//public void updateEmployee(Employee emp);
	public void deleteById(int id);
	public Employee findEmployeeById(int id);
	

}
