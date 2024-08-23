package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.exception;

public class IdNotFoundException extends RuntimeException{
	private String message="Id not found";
	
	public IdNotFoundException(String message) {
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
