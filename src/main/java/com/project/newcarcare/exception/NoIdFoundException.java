package com.project.newcarcare.exception;

public class NoIdFoundException extends RuntimeException{
	
	private String message="No Such Id Found";
	
	public NoIdFoundException() {
		
	}

	public NoIdFoundException(String message) {
	
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	

}
