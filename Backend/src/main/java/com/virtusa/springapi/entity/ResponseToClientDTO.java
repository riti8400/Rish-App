package com.virtusa.springapi.entity;

import com.virtusa.springapi.entity.airquality.AirQualityDataAPIResponseDTO;

public class ResponseToClientDTO {

	public int code;
	public String status;
	public String msg;
	public Object responseBody;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getResponseBody() {
		return responseBody;
	}
	public void setResponseBody(Object responseBody) {
		this.responseBody = responseBody;
	}
	
	
}
