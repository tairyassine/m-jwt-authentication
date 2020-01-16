package com.mauthjwt.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService{
	
	@Autowired 
	private PasswordEncoder bcryptEncoder;
		/***
		 * load user details from database
		 * */
	
	public UserDetails loadUserByUsername(String username) {
		return new org.springframework.security.core.userdetails.User("yas",bcryptEncoder.encode("123"),
				new ArrayList<>());
		//return (UserDetails) new User("yas","123");
	}
}
