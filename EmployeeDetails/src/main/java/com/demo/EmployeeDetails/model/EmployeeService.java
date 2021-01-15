package com.demo.EmployeeDetails.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repo;
	
	
	public List<Employee> getAllEmployees(){
		
		List<Employee> empList=repo.findAll();
		
		
		if(empList.size()>0) {
			return empList;
		}
		return new ArrayList<Employee>();
		
		
	}
	
	public Employee getEmployeeById(int id) throws RecordNotFoundException {
		Optional<Employee> obj=repo.findById(id);
		if(obj.isPresent()) {
			return obj.get();
		}
		else {
			throw new RecordNotFoundException("Record is not found for this id: ");
		}
		
	}
	

}
