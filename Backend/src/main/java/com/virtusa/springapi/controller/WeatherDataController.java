package com.virtusa.springapi.controller;

import java.util.Collection;
import java.util.List;

import com.virtusa.springapi.entity.CoordRequestDTO;
import com.virtusa.springapi.entity.airquality.AirQualityDataAPIResponseDTO;
import com.virtusa.springapi.entity.weather.CurrentWeatherDataDTO;
import com.virtusa.springapi.entity.weather.DailyWeatherDTO;
import com.virtusa.springapi.entity.weather.HourlyDataDTO;
import com.virtusa.springapi.entity.weather.WeatherForcastDataDTO;
import com.virtusa.springapi.services.WeatherForcastDataService;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.*;

@RestController
@RequestMapping("/weather-api")
@CrossOrigin
public class WeatherDataController {
	
	private List<AirQualityDataAPIResponseDTO> data;
	private static final Logger logger = LogManager.getLogger(WeatherDataController.class);
	
	@PostConstruct
	public void loadData() {
	}
	

	@PostMapping("/currentWhether")
	public CurrentWeatherDataDTO getData(@RequestBody CoordRequestDTO weatherRequestData){
		logger.info(weatherRequestData.getLattitude());
		logger.debug(weatherRequestData.getLongitude());
		
		WeatherForcastDataDTO data = null;
		try {
			data = WeatherForcastDataService.getWeatherByLatLong(weatherRequestData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data.getCurrent();
	}
	
	@PostMapping("/dailyWhether")
	public Collection<DailyWeatherDTO> getDailyData(@RequestBody CoordRequestDTO weatherRequestData){
		logger.info(weatherRequestData.getLattitude());
		logger.debug(weatherRequestData.getLongitude());
		
		
		WeatherForcastDataDTO data = null;
		try {
			data = WeatherForcastDataService.getWeatherByLatLong(weatherRequestData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data.getDaily();
	}
	
	@PostMapping("/hourlyWhether")
	public Collection<HourlyDataDTO> getHourlyData(@RequestBody CoordRequestDTO weatherRequestData){
		logger.info(weatherRequestData.getLattitude());
		logger.debug(weatherRequestData.getLongitude());
		
		
		WeatherForcastDataDTO data = null;
		try {
			data = WeatherForcastDataService.getWeatherByLatLong(weatherRequestData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data.getHourly();
	}
	
}
