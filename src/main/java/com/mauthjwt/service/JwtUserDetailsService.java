package com.mauthjwt.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.mauthjwt.model.User;

@Service
public class JwtUserDetailsService {
		/***
		 * load user details from database
		 * */
	
	public UserDetails loadUserByUsername(String username) {
		return (UserDetails) new User("yas","123");
	}
}
