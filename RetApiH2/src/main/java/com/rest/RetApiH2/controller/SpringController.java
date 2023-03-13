package com.rest.RetApiH2.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.RetApiH2.REPO.EmployeeRepository;
import com.rest.RetApiH2.entity.Employee;

@RestController
@RequestMapping("/emp")
public class SpringController {

	@Autowired
	EmployeeRepository employeeRepository;
	@PostMapping
	public Employee postmethod(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
		
	}
	@GetMapping("/fetchall")
	public List<Employee> getallemps(){
		return employeeRepository.findAll();
	}
	
	@PutMapping
	public Employee putmethod(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
		
	}
	
	
	@DeleteMapping
	public String deletemethod(@RequestParam Integer empId) {
		employeeRepository.deleteById(empId);
		
		return "deleted succesfully";
		
	}
	
	@GetMapping
	public Employee getallemp(@RequestParam Integer empId){
		return employeeRepository.findById(empId).get();
	}
}
