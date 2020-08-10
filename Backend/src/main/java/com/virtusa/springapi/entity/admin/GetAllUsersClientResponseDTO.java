package com.virtusa.springapi.entity.admin;

import java.util.List;

public class GetAllUsersClientResponseDTO {
	private List<GetAllUsersOutputDTO> allusers;

	public List<GetAllUsersOutputDTO> getAllusers() {
		return allusers;
	}

	public void setAllusers(List<GetAllUsersOutputDTO> allusers) {
		this.allusers = allusers;
	}
	
	

}
