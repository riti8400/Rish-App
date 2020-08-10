package com.virtusa.springapi.entity.airquality;

import java.util.Collection;

public class CityDetailsDTO {

	private Collection<Double> geo;
	private String name;
	private String url;
	public Collection<Double> getGeo() {
		return geo;
	}
	public void setGeo(Collection<Double> geo) {
		this.geo = geo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
