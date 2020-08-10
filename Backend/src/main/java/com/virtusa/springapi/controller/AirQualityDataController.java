package com.virtusa.springapi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.springapi.entity.CoordRequestDTO;
import com.virtusa.springapi.entity.ResponseToClientDTO;
import com.virtusa.springapi.entity.airquality.AirQualityDataAPIResponseDTO;
import com.virtusa.springapi.services.AirQualityDataService;

@RestController
@RequestMapping("/airQuality")
@CrossOrigin
public class AirQualityDataController extends BaseController{
	
private List<AirQualityDataAPIResponseDTO> data;
	private static final Logger logger = LogManager.getLogger(AirQualityDataService.class);
	@PostConstruct
	public void loadData() {
		
	}

	@PostMapping("/airQualityForcast")
	public ResponseToClientDTO getSortTermForcast(@RequestBody CoordRequestDTO airQualityRequest){
		
		AirQualityDataAPIResponseDTO data = null;
		ResponseToClientDTO responseData = null;
		
		try {
			 data = AirQualityDataService.getShortTermForcast(airQualityRequest);
			 System.out.println("Success Response");
			 logger.info("Resonse data received From API on Controller");
			 //logger.info(data.toString());
			 responseData = buildhttpOkResponse(data);
			 
		} catch (Exception e) {
			e.printStackTrace();
			responseData = buildHttpErrorResponse("There is some error occurred in receiving response");
		}
		return responseData;
	}
}
