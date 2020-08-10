package com.virtusa.springapi.entity.login;

public class SignupInputDataDTO {
	
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String userRole;
	private String userLoginStatus;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getUserLoginStatus() {
		return userLoginStatus;
	}
	public void setUserLoginStatus(String userLoginStatus) {
		this.userLoginStatus = userLoginStatus;
	}
	
	

}
