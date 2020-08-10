package com.virtusa.springapi.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtusa.springapi.entity.CoordRequestDTO;
import com.virtusa.springapi.entity.weather.HourlyDataDTO;
import com.virtusa.springapi.entity.weather.WeatherForcastDataDTO;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherForcastDataService{
	
	public static WeatherForcastDataDTO getWeatherByLatLong(CoordRequestDTO weatherRequestData) throws Exception{
		OkHttpClient client = new OkHttpClient();

		HttpUrl httpUrl = new HttpUrl.Builder()
				.scheme("https")
                .host("api.openweathermap.org")
                .addPathSegment("data")
                .addPathSegment("2.5")
                .addPathSegment("onecall")
                .addQueryParameter("lat", Double.toString(weatherRequestData.getLattitude()))
                .addQueryParameter("lon", Double.toString(weatherRequestData.getLongitude()))
                .addQueryParameter("appid", "74e65f6911923f704d36f80ba27c54c9")
                .build();
		
		Request request = new Request.Builder()
				.addHeader("accept", "application/json")
				.url(httpUrl)
				.get()
				.build();

		Response response = client.newCall(request).execute();
		String jsonString = response.body().string();
		System.out.println(jsonString);
		ObjectMapper objectmapper = new ObjectMapper();
		objectmapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		WeatherForcastDataDTO data = objectmapper.readValue(jsonString, WeatherForcastDataDTO.class);
		System.out.println(data.getLat());
		System.out.println(data.getLon());
		System.out.println(data.getTimezone());
		System.out.println(data.getCurrent().getSunrise());
		for (HourlyDataDTO hrData: data.getHourly()) {
			System.out.println(hrData.getPressure());
			break;
		}
		
		return data;
	}

}
