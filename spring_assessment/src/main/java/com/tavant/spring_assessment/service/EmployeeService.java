package com.tavant.spring_assessment.service;

import java.util.List;
import java.util.Optional;

import com.tavant.spring_assessment.model.Employee;

public interface EmployeeService {

	public boolean addEmployee(Employee employee);
	public Optional<Employee> updateEmployee(String empNumber, Employee employee);
	public String deleteEmployee(String empNumber);
	public Optional<Employee> getEmployeeById(String empNumber);
	public Optional<List<Employee>> getEmployees();
}
