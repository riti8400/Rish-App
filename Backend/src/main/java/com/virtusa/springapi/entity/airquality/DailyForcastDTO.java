package com.virtusa.springapi.entity.airquality;

import java.util.Collection;

public class DailyForcastDTO {

	private Collection<DailyForcastDataDTO> o3;
	private Collection<DailyForcastDataDTO> pm10;
	private Collection<DailyForcastDataDTO> pm25;
	private Collection<DailyForcastDataDTO> uvi;
	public Collection<DailyForcastDataDTO> getO3() {
		return o3;
	}
	public void setO3(Collection<DailyForcastDataDTO> o3) {
		this.o3 = o3;
	}
	public Collection<DailyForcastDataDTO> getPm10() {
		return pm10;
	}
	public void setPm10(Collection<DailyForcastDataDTO> pm10) {
		this.pm10 = pm10;
	}
	public Collection<DailyForcastDataDTO> getPm25() {
		return pm25;
	}
	public void setPm25(Collection<DailyForcastDataDTO> pm25) {
		this.pm25 = pm25;
	}
	public Collection<DailyForcastDataDTO> getUvi() {
		return uvi;
	}
	public void setUvi(Collection<DailyForcastDataDTO> uvi) {
		this.uvi = uvi;
	}
	
	
	
}
