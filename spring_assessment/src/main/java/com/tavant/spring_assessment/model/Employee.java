package com.tavant.spring_assessment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(length = 10)
	@NotBlank(message = "Employee Number must not be blank")
	private String employeeNumber;

	@NotBlank(message = "Employee First Name cannot be null")
	@Column(length = 15)
	private String firstName;
	
	@NotBlank(message = "Employee Last Name cannot be null")
	@Column(length = 15)
	private String lastName;
	
	@NotBlank(message = "Employee should have an email id")
	@Email(message = "Email sould be valid")
	@Column(length = 20)
	private String email;
	
	@Column(length = 10)
	private String extension;
	
	@NotBlank(message = "Office code must be associated to each employee")
	@Column(length = 10)
	private String officeCode;
	
	@NotBlank(message = "Each employee must report to some higher officials")
	@Column(length = 10)
	private String reportTo;
	
	@NotBlank(message = "Job Title is associated to each employee")
	@Column(length = 10)
	private String jobTitle;
	
	@NotBlank(message = " Each employee have an updated address")
	@Column(length = 20)
	private String address;
	
}
