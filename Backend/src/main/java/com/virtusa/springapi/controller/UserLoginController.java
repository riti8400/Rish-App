package com.virtusa.springapi.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.springapi.entity.ResponseToClientDTO;
import com.virtusa.springapi.entity.login.LoginInputDataDTO;
import com.virtusa.springapi.entity.login.LoginOutputDataDTO;
import com.virtusa.springapi.entity.login.ResetPasswordInputDataDTO;
import com.virtusa.springapi.entity.login.SignupInputDataDTO;
import com.virtusa.springapi.services.UserLoginServices;


@RestController
@RequestMapping("/loginservices")
@CrossOrigin
public class UserLoginController extends BaseController{
	private static final Logger logger = LogManager.getLogger(UserLoginController.class);

	@PostMapping("/login")
	public ResponseToClientDTO login(@RequestBody LoginInputDataDTO loginData) {
		logger.info("Login data Received");
		
		ResponseToClientDTO responseData = null;
		logger.info("User Id: " + loginData.getUserId() + " Password: "+ loginData.getPassword());
		try {
			LoginOutputDataDTO response = UserLoginServices.login(loginData);
			responseData = buildhttpOkResponse(response);
		} catch (Exception e) {
			responseData = buildHttpErrorResponse("Error! Some error occured while Login, Please Try Again");
		}
		
		return responseData;
	}
	
	@PostMapping("/signup")
	public ResponseToClientDTO signup(@RequestBody SignupInputDataDTO signupData) {
		
		logger.info("Signup data reveived");
		ResponseToClientDTO responsedata = null;
		try {
			String response = UserLoginServices.signupService(signupData);
			responsedata = buildhttpOkResponse(response);
		} catch (Exception e) {
			responsedata = buildHttpErrorResponse("Error! Some Error occurred while user registration.");
		}
		
		return responsedata;
		
	}
	
	@PostMapping("/resetPassword")
	public ResponseToClientDTO resetPassword(@RequestBody ResetPasswordInputDataDTO resetPasswordData) {
		//LoginOutputDataDTO responseData = null;
		  logger.info("Login data Received"); 
		  logger.info("User Name: " + resetPasswordData.getUserName() + " Security Code: "+ resetPasswordData.getSecurityCode()); 
		  
		  ResponseToClientDTO responsedata = null;
		  
		  try { 
			  String response = UserLoginServices.ResetPasswordService(resetPasswordData);
			  responsedata = buildhttpOkResponse(response);
		  
		  } catch (Exception e) { 
			   responsedata = buildHttpErrorResponse("Error! Some Error Occurred while changing password");
		  }
		 
		  return responsedata;
	}
}
