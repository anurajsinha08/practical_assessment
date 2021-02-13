package com.tavant.spring_assessment.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.spring_assessment.exception.EmployeeNotFoundException;
import com.tavant.spring_assessment.exception.NoEmployeeFoundException;
import com.tavant.spring_assessment.model.Employee;
import com.tavant.spring_assessment.service.EmployeeService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/employee")

public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/all")
	public Optional<List<Employee>> getEmployees() throws NoEmployeeFoundException {
		Optional<List<Employee>> emp = employeeService.getEmployees();
		if(emp.get().size()==0) {
//			throw an exception
			throw new NoEmployeeFoundException("No Employee Data exist");
		}
		else {
			return emp;
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") String empNumber) throws EmployeeNotFoundException {
		Optional<Employee> emp = employeeService.getEmployeeById(empNumber);
		if(emp.isPresent()) {
			return ResponseEntity.ok(emp.get());
		}
		else {
//			Throw an exception
			throw new EmployeeNotFoundException("Employee Details Not found");
		}
	}
	
	@PostMapping("/post")
	public boolean addEmployee(@RequestBody @Valid Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") String empNumber) throws EmployeeNotFoundException {
		
		String res = employeeService.deleteEmployee(empNumber);
		if(res.equals("Success")){
			return ResponseEntity.ok(res);
		}
		else {
			throw new EmployeeNotFoundException("Employee To be Deleted does not exist");
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable("id") String empNumber,@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
		
		Optional<Employee> emp = employeeService.updateEmployee(empNumber, employee);
		
		if(emp.isPresent()) {
			return ResponseEntity.ok(emp.get());
		} else {
			throw new EmployeeNotFoundException("Employee Details to be updated not found");
		}
		
	}
	
	
}
