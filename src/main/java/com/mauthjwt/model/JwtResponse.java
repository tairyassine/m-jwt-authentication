package com.mauthjwt.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6637918773794746100L;
	
	private String token;
	
	public JwtResponse(String token) {
		this.token= token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
