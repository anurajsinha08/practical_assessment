package com.tavant.spring_assessment.exception;

public class EmployeeNotFoundException extends Exception {

	public EmployeeNotFoundException(String msg) {
		super(msg);
	}
	
	@Override
	public String toString() {
	
		return super.toString()+super.getMessage();
	}
}
