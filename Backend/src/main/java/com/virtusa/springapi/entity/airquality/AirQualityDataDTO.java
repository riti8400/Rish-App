package com.virtusa.springapi.entity.airquality;

import java.util.Collection;

public class AirQualityDataDTO {
	
	private int aqi;
	private int idx;
	private Collection<AttributionsDataDTO> attributions;
	private CityDetailsDTO city;
	private String dominentpol;
	private ForcastDataDTO forecast;
	public int getAqi() {
		return aqi;
	}
	public void setAqi(int aqi) {
		this.aqi = aqi;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public Collection<AttributionsDataDTO> getAttributions() {
		return attributions;
	}
	public void setAttributions(Collection<AttributionsDataDTO> attributions) {
		this.attributions = attributions;
	}
	public CityDetailsDTO getCity() {
		return city;
	}
	public void setCity(CityDetailsDTO city) {
		this.city = city;
	}
	public String getDominentpol() {
		return dominentpol;
	}
	public void setDominentpol(String dominentpol) {
		this.dominentpol = dominentpol;
	}
	public ForcastDataDTO getForecast() {
		return forecast;
	}
	public void setForecast(ForcastDataDTO forecast) {
		this.forecast = forecast;
	}
	
	
	

}
