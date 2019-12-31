package com.mauthjwt.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.mauthjwt.configuration.JwtTokenUtil;

@Component
public class JwtAuthenticationProcess {
	
	@Autowired 
	private static AuthenticationManager authenticationManager;
	
	@Autowired 
	private UserDetailsService userDetailsService;
	
	@Autowired 
	private JwtTokenUtil jwtTokenUtil;
	
	
	public void authenticate(String username, String password) throws Exception {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(username,password) );
	}
	
	public UserDetails loadUser(String username) {
			return userDetailsService.loadUserByUsername(username);
	}
	
	public String generateToken(UserDetails userDetails) {
		return jwtTokenUtil.generateToken(userDetails);
	}
	

}
