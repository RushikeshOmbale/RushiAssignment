package com.RushikeshAssignment.Status;

public class APIError {

	private String status;
    
	private Object errorResponse;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(String errorResponse) {
		this.errorResponse = errorResponse;
	}

	
	public APIError(String status, Object errorResponse) {
		super();
		this.status = status;
		this.errorResponse = errorResponse;
	}

	public APIError() {
		super();
		
	}
	
	
}
