package com.tavant.spring_assessment.errorresponse;

import lombok.Data;

@Data
public class ApiValidationError extends ApiSubError {
	private String object;
	private String field;
	private String message;
	private Object rejectedValue;
	
	public ApiValidationError(String object, String message) {
		this.object = object;
		this.message = message;
	}
	
	public ApiValidationError(String object, String message, Object rejectedValue, String field) {
		
		super();
		this.object=object;
		this.field = field;
		this.message = message;
		this.rejectedValue = rejectedValue;
	}
}
