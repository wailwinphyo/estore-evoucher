package com.codetest.estoreevoucher.Model;

import java.util.List;

import lombok.Data;

@Data
public class JwtResponse {

	public JwtResponse(long id, String name, List<String> roles, String refreshToken) {
		super();
		this.id = id;
		this.name = name;
		this.roles = roles;
		this.refreshToken = refreshToken;
	}
	
	private long id;
	
	private String name;
	
	private List<String> roles;
	
	private String type = "Bearer";
	
	private String refreshToken;
}
