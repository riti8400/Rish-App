package com.virtusa.springapi.entity.login;

public class ResetPasswordInputDataDTO {
	
	private String userName;
	private int securityCode;
	private String newPassword;
	private String retypeNewPassword;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getRetypeNewPassword() {
		return retypeNewPassword;
	}
	public void setRetypeNewPassword(String retypeNewPassword) {
		this.retypeNewPassword = retypeNewPassword;
	}
	
	

}
