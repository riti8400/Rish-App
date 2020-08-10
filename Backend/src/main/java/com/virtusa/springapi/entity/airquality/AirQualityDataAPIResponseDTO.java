package com.virtusa.springapi.entity.airquality;

public class AirQualityDataAPIResponseDTO {

	private String status;
	private AirQualityDataDTO data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public AirQualityDataDTO getData() {
		return data;
	}
	public void setData(AirQualityDataDTO data) {
		this.data = data;
	}
	
}
