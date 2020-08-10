package com.virtusa.springapi.entity.weather;

import java.util.Collection;

public class DailyWeatherDTO {

	private long dt;
	private long sunrise;
	private long sunset;
	private TemperatureDataDTO temp;
	private FeelsLikeDTO feels_like;
	private int pressure;
	private int humidity;
	private double dew_point;
	private double wind_speed;
	private int wind_deg;
	private Collection<WeatherDataDTO> weather;
	private int clouds;
	private double pop;
	private double rain;
	private double uvi;
	
	
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
	public TemperatureDataDTO getTemp() {
		return temp;
	}
	public void setTemp(TemperatureDataDTO temp) {
		this.temp = temp;
	}
	public FeelsLikeDTO getFeels_like() {
		return feels_like;
	}
	public void setFeels_like(FeelsLikeDTO feels_like) {
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
	public double getWind_speed() {
		return wind_speed;
	}
	public void setWind_speed(double wind_speed) {
		this.wind_speed = wind_speed;
	}
	public int getWind_deg() {
		return wind_deg;
	}
	public void setWind_deg(int wind_deg) {
		this.wind_deg = wind_deg;
	}
	public Collection<WeatherDataDTO> getWeather() {
		return weather;
	}
	public void setWeather(Collection<WeatherDataDTO> weather) {
		this.weather = weather;
	}
	public int getClouds() {
		return clouds;
	}
	public void setClouds(int clouds) {
		this.clouds = clouds;
	}
	public double getPop() {
		return pop;
	}
	public void setPop(double pop) {
		this.pop = pop;
	}
	public double getRain() {
		return rain;
	}
	public void setRain(double rain) {
		this.rain = rain;
	}
	public double getUvi() {
		return uvi;
	}
	public void setUvi(double uvi) {
		this.uvi = uvi;
	}
	
	
}
