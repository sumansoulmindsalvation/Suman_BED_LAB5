package com.gl.empmgmt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.empmgmt.dao.EmployeeRepository;
import com.gl.empmgmt.entity.Employee;


@Service
public class EmployeeServiceImpl {

	@Autowired
	EmployeeRepository repository;

	public List<Employee> getAlEmployee() {	
		return repository.findAll();
	}
	

	public void save(Employee emp) {
		repository.save(emp);
	}

	public int deleteById(int id) {
		repository.deleteById(id);
		return id;
	}

	
	public Employee findById(int id) {
		Optional<Employee> optEmp = repository.findById(id);
		if(optEmp.isPresent()) {
			return optEmp.get();
		}else {	
		throw new RuntimeException("Em not present "+id);
		}
	}
	

}
