package com.isnit.rest.webservices.restfulwebservices.exceptions;

import java.util.Date;

public class ExceptionResponse{
	private Date timestanp;
	private String message;
	private String details;

	
	public ExceptionResponse(Date timestanp, String message, String details) {
		super();
		this.timestanp = timestanp;
		this.message = message;
		this.details = details;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [timestanp=" + timestanp + ", message=" + message + ", details=" + details + "]";
	}

	public Date getTimestanp() {
		return timestanp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}
