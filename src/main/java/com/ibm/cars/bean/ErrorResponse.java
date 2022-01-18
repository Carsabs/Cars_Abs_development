package com.ibm.cars.bean;

public class ErrorResponse {
	
	private String message ="";
	private String status="";
	private String source="";
	
	
	
	
	public ErrorResponse(String message, String status, String source) {
		super();
		this.message = message;
		this.status = status;
		this.source = source;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	

}
