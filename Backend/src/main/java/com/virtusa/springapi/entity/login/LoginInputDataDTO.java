package com.virtusa.springapi.entity.login;

public class LoginInputDataDTO {
	
	private String userName;
	private String password;
	private String userRole;
	
	public String getUserId() {
		return userName;
	}
	public void setUserId(String userId) {
		this.userName = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	
}
