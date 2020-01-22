package com.mauthjwt.envelope.response;

import java.io.Serializable;

import com.mauthjwt.web.dto.commun.ResultSet;

public class JwtResponse implements Serializable,ResultSet {

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
