package com.tavant.spring_assessment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.spring_assessment.model.Employee;
import com.tavant.spring_assessment.repository.EmployeeRepository;

@Service
public class EmployeeSericeImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public boolean addEmployee(Employee employee) {
	
		Employee emp = employeeRepository.save(employee);
		return emp!=null;
	}

	@Override
	public Optional<Employee> updateEmployee(String empNumber, Employee employee) {
		
		Optional<Employee> emp = employeeRepository.findById(empNumber);
		if(emp.isPresent()) {
			Employee e = emp.get();
			e.setAddress(employee.getAddress());
			e.setEmail(employee.getEmail());
			e.setEmployeeNumber(employee.getEmployeeNumber());
			e.setExtension(employee.getExtension());
			e.setFirstName(employee.getFirstName());
			e.setJobTitle(employee.getJobTitle());
			e.setLastName(employee.getLastName());
			e.setOfficeCode(employee.getOfficeCode());
			e.setReportTo(employee.getOfficeCode());
			
			final Employee details = employeeRepository.save(e);
			return Optional.ofNullable(details);
		}
		return null;
	}

	@Override
	public String deleteEmployee(String empNumber) {
		
		if(employeeRepository.existsById(empNumber)) {
			employeeRepository.deleteById(empNumber);
			return "Success";
		}
		return "Fail";
	}

	@Override
	public Optional<Employee> getEmployeeById(String empNumber) {
		
		return employeeRepository.findById(empNumber);
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		
		return Optional.ofNullable(employeeRepository.findAll());
	}

}
