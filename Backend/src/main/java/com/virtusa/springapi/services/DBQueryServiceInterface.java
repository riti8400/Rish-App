package com.virtusa.springapi.services;

public interface DBQueryServiceInterface {

	public static final String GET_LOGIN_USER = "select user_id, first_name, last_name, user_name ,status from user_info where user_name = ? && password = ?";
	public static final String USER_SIGNUP = "call user_login(?, ? , ?, ?, ?, ?, ?, ?)";
	public static final String RESET_PASSWORD = "call reset_password(?, ?, ?, ?, ?)";
	public static final String GET_ALL_USERS = "select first_name, last_name, User_Name, user_role, status, created_date from user_info where user_role='U'";
	public static final String UPDATE_LOGIN_STATUS = "update user_info set status = ? where user_name = ? && user_role='U'";
	public static final String ADD_SECURITY_CODE = "call add_security_code(?, ?, ?, ?)";
}

