package com.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2.dao.EmployeeRepository;
import com.h2.model.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping(value="/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeRepository.save(employee),HttpStatus.CREATED);
	}
	
	@GetMapping(value="/getAllEmployees")
	public ResponseEntity<List<Employee>> getAll(){
		return new ResponseEntity<List<Employee>>(employeeRepository.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(value="/getEmployeeByDept/{dept}")
	public ResponseEntity<List<Employee>> getEmployeeByDept(@PathVariable String dept){
		return new ResponseEntity<List<Employee>>(employeeRepository.findByDept(dept),HttpStatus.OK);
	} 
	

}
