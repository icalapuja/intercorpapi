package com.valcom.icalapuja.intercorpapi.resource;

public class ResponseBodyResource {
	public ResponseBodyResource(int status,String error,String message) {
		this.status = status;
		this.error = error;
		this.message = message;
	}
	
	private int status;
	private String error;
	private String message;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
