package com.virtusa.springapi.services;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtusa.springapi.controller.HttpResponseErrorException;
import com.virtusa.springapi.entity.CoordRequestDTO;
import com.virtusa.springapi.entity.airquality.AirQualityDataAPIResponseDTO;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AirQualityDataService {
	
	private static final Logger logger = LogManager.getLogger(AirQualityDataService.class);
	
	public static AirQualityDataAPIResponseDTO getShortTermForcast(CoordRequestDTO airQualityRequest) throws Exception{
		
		
		OkHttpClient client = new OkHttpClient();

		HttpUrl httpUrl = new HttpUrl.Builder()
				.scheme("https")
                .host("api.waqi.info")
                .addPathSegment("feed")
                .addPathSegment("geo:"+airQualityRequest.getLattitude()+";"+airQualityRequest.getLongitude())
                .addPathSegment("")
                .addQueryParameter("token", "15ff0eb49d22efcd8e83bf3532faf993a596ca75")
                .build();
		
		//logger.info(httpUrl.toString());
		
		Request request = new Request.Builder()
				//.addHeader("accept", "application/json")
				.url(httpUrl)
				.get()
				.build();

		Response response = client.newCall(request).execute();
		
		logger.info("Response data received from Air Quality API");
		//logger.info(response);
		AirQualityDataAPIResponseDTO data;
		if (response.code() == 200) {

			String jsonString = response.body().string();
			logger.info("Success Response Data received from Air Quality API");
			logger.info(jsonString);
			ObjectMapper objectmapper = new ObjectMapper();
			objectmapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false); 
			data = objectmapper.readValue(jsonString,AirQualityDataAPIResponseDTO.class);
			
			
		} else {
			//TODO throw http error exception
			logger.info("Error Data Received from Air Quality API");
			throw new HttpResponseErrorException(response.message()+" : There is Some Error in fetching data");
		}
		
		return data;
	}
}
