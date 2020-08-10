package com.virtusa.springapi.entity.admin;

public class UpdateUserInputDataDTO {
	
	private String userName;
	private boolean doActivate;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean isDoActivate() {
		return doActivate;
	}
	public void setDoActivate(boolean doActivate) {
		this.doActivate = doActivate;
	}
	
	

}
