package com.virtusa.springapi.entity.weather;

import java.util.Collection;


public class WeatherForcastDataDTO {

	private double lat;
	private double lon;
	private String timezone;
	private CurrentWeatherDataDTO current;
	private Collection<HourlyDataDTO> hourly;
	private Collection<DailyWeatherDTO> daily;
	
	
	public Collection<DailyWeatherDTO> getDaily() {
		return daily;
	}
	public void setDaily(Collection<DailyWeatherDTO> daily) {
		this.daily = daily;
	}
	public Collection<HourlyDataDTO> getHourly() {
		return hourly;
	}
	public void setHourly(Collection<HourlyDataDTO> hourly) {
		this.hourly = hourly;
	}
	public CurrentWeatherDataDTO getCurrent() {
		return current;
	}
	public void setCurrent(CurrentWeatherDataDTO current) {
		this.current = current;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}	

}
