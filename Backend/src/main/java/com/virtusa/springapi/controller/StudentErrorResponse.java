package com.virtusa.springapi.controller;

public class StudentErrorResponse {
	
	private int status;
	private String Message;
	private int timeStamp;
	
	public StudentErrorResponse() {
		
	}

	public StudentErrorResponse(int status, String message, int timeStamp) {
		this.status = status;
		Message = message;
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public int getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(int timeStamp) {
		this.timeStamp = timeStamp;
	}

}
