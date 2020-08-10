package com.virtusa.springapi.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.springapi.entity.ResponseToClientDTO;
import com.virtusa.springapi.entity.admin.GenerateSecurityCodeInputDTO;
import com.virtusa.springapi.entity.admin.GetAllUsersClientResponseDTO;
import com.virtusa.springapi.entity.admin.UpdateUserInputDataDTO;
import com.virtusa.springapi.services.AdminDataServices;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController extends BaseController{
	private static final Logger logger = LogManager.getLogger(AdminController.class);
	
	@GetMapping("/getAllUsers")
	public ResponseToClientDTO getAllUsers() {
		logger.info("Request for get All user's data from admin Received");
		GetAllUsersClientResponseDTO allUsers = new GetAllUsersClientResponseDTO();
		ResponseToClientDTO responsedata = null;
		try {
			allUsers.setAllusers(AdminDataServices.getAllRegisteredUsers());
			
			responsedata = buildhttpOkResponse(allUsers);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			buildHttpErrorResponse("Some Error Occurred! not able to fetch users.");
		}
		
		return responsedata;	
	}
	
	@PostMapping("/updateLoginStatus")
	public ResponseToClientDTO updateLoginStatus(@RequestBody UpdateUserInputDataDTO updateUserStatusData) {
		logger.info("Request Received for update user login Status");
		logger.info("user_name : "+ updateUserStatusData.getUserName() + " doActivate : "+updateUserStatusData.isDoActivate());
		String returnMsg = null;
		ResponseToClientDTO responsedata = null;
		try {
			 returnMsg = AdminDataServices.updateUserLoginStatus(updateUserStatusData);
			 responsedata = buildhttpOkResponse(returnMsg);
		} catch (Exception e) {
			
			responsedata = buildHttpErrorResponse("Error! login status not updated, Some Error occurred");
		}
		
		return responsedata; 
		
	}
	
	@PostMapping("/generateSecurityCode")
	public ResponseToClientDTO generateSecurityCode(@RequestBody GenerateSecurityCodeInputDTO userData) {
		logger.info(userData.getUserName());
		String mesg = null;
		ResponseToClientDTO responsedata = null;
		
		try {
			mesg = AdminDataServices.generateSecurityCode(userData.getUserName());
			responsedata = buildhttpOkResponse(mesg);
		} catch (Exception e) {
			responsedata = buildHttpErrorResponse("Error! Security code not generated, Some Error Occurred");
			
		}
		
		return responsedata;
	}
	

}
