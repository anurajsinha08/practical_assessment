package com.tavant.spring_assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tavant.spring_assessment.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
