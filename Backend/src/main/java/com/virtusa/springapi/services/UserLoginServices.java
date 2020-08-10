package com.virtusa.springapi.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

import com.virtusa.springapi.entity.login.LoginInputDataDTO;
import com.virtusa.springapi.entity.login.LoginOutputDataDTO;
import com.virtusa.springapi.entity.login.ResetPasswordInputDataDTO;
import com.virtusa.springapi.entity.login.SignupInputDataDTO;

public class UserLoginServices {
	
	public static LoginOutputDataDTO login (LoginInputDataDTO loginData) throws Exception{
		
		Connection con = DbConnectionService.getConnection();
		PreparedStatement stmt = con.prepareStatement(DBQueryServiceInterface.GET_LOGIN_USER);
		stmt.setString(1, loginData.getUserId());
		stmt.setString(2, loginData.getPassword());
		
		ResultSet rs = stmt.executeQuery();
		LoginOutputDataDTO responseData = new LoginOutputDataDTO();
		if(rs.next()) {
			responseData.setFirstName(rs.getString("first_name"));
			responseData.setLastName(rs.getString("last_name"));
			responseData.setUsername(rs.getString("user_name"));
			responseData.setActiveStatus(rs.getString("status"));
			
			if(rs.getString("status").equalsIgnoreCase("A")) {
				responseData.setLoginMessage("User Login Successfully");
				responseData.setLoginStatus(true);
			} else {
				responseData.setLoginMessage("You are cuurently De-activated, Please contact administrator");
				responseData.setLoginStatus(false);
			}
			
		} else {
			responseData.setLoginStatus(false);
			responseData.setLoginMessage("Invalid Credentials ! Please check your user name and password");
		}
		DbConnectionService.closeConnection(con);
		return responseData;
	}
	
	//	Method to reset password
	public static String ResetPasswordService (ResetPasswordInputDataDTO resetPasswordData) throws Exception {
		Connection con = DbConnectionService.getConnection();
		CallableStatement stmt = con.prepareCall(DBQueryServiceInterface.RESET_PASSWORD);
		
		stmt.setString(1, resetPasswordData.getUserName());
		stmt.setInt(2, resetPasswordData.getSecurityCode());
		stmt.setString(3, resetPasswordData.getNewPassword());
		
		stmt.registerOutParameter(4, Types.INTEGER);
		stmt.registerOutParameter(5, Types.VARCHAR);
		
		ResultSet rs = stmt.executeQuery();
		String mesg = null;
		
		if (rs.next()) {
			int responseCode = rs.getInt("out_response_code");
			if (responseCode == 200) {
				mesg = rs.getString("output_msg");
			} else {
				mesg = rs.getString("output_msg");
			}
		} else {
			mesg = "Error! There is Some Error in updating password.";
		}
		DbConnectionService.closeConnection(con);
		
		return mesg;
	}
	
	public static String signupService(SignupInputDataDTO signupData) throws Exception{
		Connection con = DbConnectionService.getConnection();
		CallableStatement stmt = con.prepareCall(DBQueryServiceInterface.USER_SIGNUP);
		stmt.setString(1, signupData.getFirstName());
		stmt.setString(2, signupData.getLastName());
		stmt.setString(3, signupData.getUserName());
		stmt.setString(4, signupData.getPassword());
		stmt.setString(5, signupData.getUserRole());
		stmt.setString(6, signupData.getUserLoginStatus());
		
		stmt.registerOutParameter(7, Types.INTEGER);
		stmt.registerOutParameter(8, Types.VARCHAR);
		
		ResultSet rs = stmt.executeQuery();
		String mesg = null;
		
		if (rs.next()) {
			int responseCode = rs.getInt("out_response_code");
			if (responseCode == 200) {
				mesg = rs.getString("output_msg");
			} else {
				mesg = rs.getString("output_msg");
			}
		} else {
			mesg = "Error! There is Some Error in user registration.";
		}
		
		DbConnectionService.closeConnection(con);
		
		return mesg;
	}
	
}
