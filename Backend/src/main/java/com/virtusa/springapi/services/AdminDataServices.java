package com.virtusa.springapi.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.virtusa.springapi.entity.admin.GetAllUsersOutputDTO;
import com.virtusa.springapi.entity.admin.UpdateUserInputDataDTO;

public class AdminDataServices {

	public static List<GetAllUsersOutputDTO> getAllRegisteredUsers() throws Exception{
		
		List<GetAllUsersOutputDTO> allUsers = new ArrayList<GetAllUsersOutputDTO>();
		
		Connection con = DbConnectionService.getConnection();
		PreparedStatement stmt = con.prepareStatement(DBQueryServiceInterface.GET_ALL_USERS);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			GetAllUsersOutputDTO userData = new GetAllUsersOutputDTO();
			userData.setFirstName(rs.getString("first_name"));
			userData.setLastName(rs.getString("last_name"));
			userData.setUserName(rs.getString("user_name"));
			userData.setLoginStatus(rs.getString("status"));
			userData.setUserRole(rs.getNString("user_role"));
			userData.setCreatedDate(rs.getString("created_date"));
			
			allUsers.add(userData);
		}
		DbConnectionService.closeConnection(con);
		
		return allUsers;
	}
	
	public static String updateUserLoginStatus(UpdateUserInputDataDTO updateLoginData) throws Exception{
		
		String returnMsg = null;
		String updateStatus = (updateLoginData.isDoActivate()) ? "A" : "D";
		Connection con = DbConnectionService.getConnection();
		
		PreparedStatement stmt = con.prepareStatement(DBQueryServiceInterface.UPDATE_LOGIN_STATUS);
		stmt.setString(1, updateStatus);
		stmt.setString(2, updateLoginData.getUserName());
		
		int i = stmt.executeUpdate();
		if(i>0) {
			returnMsg = "Success! Login Status Updated Successfully.";
		}else {
			returnMsg = "Error! Login status not updated, Please check user details.";
		}
		DbConnectionService.closeConnection(con);
		return returnMsg;
	}
	
	public static String generateSecurityCode (String userName) throws Exception{
		Random rand = new Random();
		int securityCode = rand.nextInt((9999 - 100) + 1) + 10;
		
		String mesg = null;
		
		Connection con = DbConnectionService.getConnection();
		CallableStatement stmt = con.prepareCall(DBQueryServiceInterface.ADD_SECURITY_CODE);
		stmt.setInt(1, securityCode);
		stmt.setString(2, userName);

	    stmt.registerOutParameter(3, Types.INTEGER);
		stmt.registerOutParameter(4, Types.VARCHAR);
		
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			int responseCode = rs.getInt("out_response_code");
			if (responseCode == 200) {
				mesg = "Success! Security Code Successfully Generated for "+ userName + " : " + securityCode;
			} else {
				mesg = rs.getString("output_msg");
			}
		} else {
			mesg = "Error! Security code cannot be generated.";
		}
		
		System.out.println(mesg);
		DbConnectionService.closeConnection(con);
		return mesg;
	}
}