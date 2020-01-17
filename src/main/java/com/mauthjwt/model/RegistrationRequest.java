package com.mauthjwt.model;

import java.io.Serializable;

public class RegistrationRequest implements Serializable {
	
	private static final long serialVersionUID = 8052382398032049761L;
	
	private String firstName;
	private String LastName;
	private String password;
	private String email;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
