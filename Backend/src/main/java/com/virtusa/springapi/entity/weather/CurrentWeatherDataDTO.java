package com.virtusa.springapi.entity.weather;

import java.util.Collection;

public class CurrentWeatherDataDTO {

	private long dt;
	private long sunrise;
	private long sunset;
	private double temp;
	private double feels_like;
	
	private int pressure;
	private int humidity;
	private double dew_point;
	private int visibility;
	private double wind_speed;
	private double wind_deg;
	private Collection<WeatherDataDTO> weather;
	
	public long getDt() {
		return dt;
	}
	public void setDt(long dt) {
		this.dt = dt;
	}
	public long getSunrise() {
		return sunrise;
	}
	public void setSunrise(long sunrise) {
		this.sunrise = sunrise;
	}
	public long getSunset() {
		return sunset;
	}
	public void setSunset(long sunset) {
		this.sunset = sunset;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	
	public double getFeels_like() {
		return feels_like;
	}
	public void setFeels_like(double feels_like) {
		this.feels_like = feels_like;
	}
	public int getPressure() {
		return pressure;
	}
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public double getDew_point() {
		return dew_point;
	}
	public void setDew_point(double dew_point) {
		this.dew_point = dew_point;
	}
	public int getVisibility() {
		return visibility;
	}
	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}
	public double getWind_speed() {
		return wind_speed;
	}
	public void setWind_speed(double wind_speed) {
		this.wind_speed = wind_speed;
	}
	public double getWind_deg() {
		return wind_deg;
	}
	public void setWind_deg(double wind_deg) {
		this.wind_deg = wind_deg;
	}
	public Collection<WeatherDataDTO> getWeather() {
		return weather;
	}
	public void setWeather(Collection<WeatherDataDTO> weather) {
		this.weather = weather;
	}
	
}
