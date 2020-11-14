package com.springlearning.rest.restfulwebservices.exceptions;

import java.util.Date;

public class ExceptionResponse {
	
	//timestamp of exception
	//message of exception
	//details
	
	private Date timestamp;
	private String message;
	private String details;
	
	public ExceptionResponse(Date timeStamp, String message, String details) {
		super();
		this.timestamp = timeStamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimeStamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	
	
	
	
	
}
