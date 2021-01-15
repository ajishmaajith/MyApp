package com.demo.EmployeeDetails.model;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeControlller {
	
	@Autowired
	EmployeeService emp;
	
	@GetMapping("Employee")
	
	public ResponseEntity<List<Employee>> getEmployees(){
		
	List<Employee> list=emp.getAllEmployees();
		
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);

}
	@GetMapping("EmployeeById/{id}")
	public Employee getEmployeeById(@PathVariable("id") int id) throws RecordNotFoundException {
		
		return emp.getEmployeeById(id);
		
	}
	
	
	
}