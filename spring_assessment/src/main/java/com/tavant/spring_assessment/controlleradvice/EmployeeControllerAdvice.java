package com.tavant.spring_assessment.controlleradvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.tavant.spring_assessment.errorresponse.ErrorResponse;
import com.tavant.spring_assessment.exception.EmployeeNotFoundException;
import com.tavant.spring_assessment.exception.NoEmployeeFoundException;

@ControllerAdvice
public class EmployeeControllerAdvice {

	@ExceptionHandler(NoEmployeeFoundException.class)
	
	public final ResponseEntity<ErrorResponse> handleNoEmployeeFoundException(NoEmployeeFoundException e, WebRequest request) {
		
		List<String> details = new ArrayList<String>();
		
		details.add(e.getLocalizedMessage());
		
		ErrorResponse errorResponse = new ErrorResponse("INCORRECT REQUEST", details);
		return new ResponseEntity(errorResponse,HttpStatus.NOT_FOUND);	
	}
	
@ExceptionHandler(EmployeeNotFoundException.class)
	
	public final ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException e, WebRequest request) {
		
		List<String> details = new ArrayList<String>();
		
		details.add(e.getLocalizedMessage());
		
		ErrorResponse errorResponse = new ErrorResponse("INCORRECT REQUEST", details);
		return new ResponseEntity(errorResponse,HttpStatus.NOT_FOUND);	
	}
}
