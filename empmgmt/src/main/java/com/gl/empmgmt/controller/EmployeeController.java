package com.gl.empmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.empmgmt.entity.Employee;
import com.gl.empmgmt.service.EmployeeService;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService  empService;
	
	
	/*
	 *  /employees/ --GET
	 *  /employees/new --GET
	 *  /employees/edit/{id} --GET
	 *  /employees/delete/{id} --GET
	 *  /employee/save --POST
	 *  /employees/save/{id} --POST
	 * 
	 */
	
	@GetMapping("/")
	public String getAllEmployees(Model model) {
		model.addAttribute("employees", new Employee());
		return "employees";
	}
	
	@GetMapping("/new")
	public String addEmployee(Model model) {
		model.addAttribute("employees", empService.getAlEmployee());
		return "create_emp";
	}
	
	
	@GetMapping("/edit/{id}")
	public String editEmployee(@PathVariable(name = "id") Integer id  ,Model model) {
		model.addAttribute("employees", empService.findEmployeeById(id));
		return "edit_emp";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable(name = "id") Integer id  ,Model model) {
		empService.deleteById(id);
		return "redirect:/employees/";
	}
	
	@PostMapping("/save")
	public String createEmployee(@ModelAttribute(name="employee") Employee emp) {
		empService.createEmployee(emp);
		return "redirect:/employees/";
	}
	
		
	@PostMapping("/save/{id}")
	public String createEmployee(@PathVariable(name="id") Integer id,@ModelAttribute(name = "employees") Employee emp) {
		emp.setId(id);
		empService.createEmployee(emp);
		return "redirect:/employees/";
	}	

	

}
