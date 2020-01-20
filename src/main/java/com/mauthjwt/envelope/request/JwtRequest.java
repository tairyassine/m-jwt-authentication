package com.mauthjwt.envelope.request;

import java.io.Serializable;

public class JwtRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8052382398032049761L;
	
	
	private String userEmail;
	private String password;
	private String alias;
	
	public JwtRequest() {
		
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String username) {
		this.userEmail = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
}