package com.virtusa.springapi.controller;

import com.virtusa.springapi.entity.ResponseToClientDTO;
import com.virtusa.springapi.entity.airquality.AirQualityDataAPIResponseDTO;

public class BaseController {
	
	protected ResponseToClientDTO buildhttpOkResponse( Object responseBody) {
		ResponseToClientDTO responseData = new ResponseToClientDTO();
		responseData.setCode(200);
		responseData.setMsg("Success");
		responseData.setResponseBody(responseBody);
		return responseData;
	}
	
	protected ResponseToClientDTO buildHttpErrorResponse(String message) {
		ResponseToClientDTO responseData = new ResponseToClientDTO();
		responseData.setCode(500);
		responseData.setMsg(message);
		return responseData;
	}

}
