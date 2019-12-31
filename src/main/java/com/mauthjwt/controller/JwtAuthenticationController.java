package com.mauthjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mauthjwt.facade.JwtAuthenticationProcess;
import com.mauthjwt.model.JwtRequest;
import com.mauthjwt.model.JwtResponse;

@RestController
public class JwtAuthenticationController {
	
	@Autowired
	private JwtAuthenticationProcess jwtAuthenticationProcess;
	
	@PostMapping(value="/authenticate")
	public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authenticationRequest){
		String token=null;
		try {
			jwtAuthenticationProcess.
			authenticate(authenticationRequest.getUsername(),
					authenticationRequest.getPassword());
			
			final UserDetails userDetails = jwtAuthenticationProcess.loadUser(authenticationRequest.getUsername());
			token = jwtAuthenticationProcess.generateToken(userDetails);
			
		}catch(Exception e) {
			
		}
		
		return ResponseEntity.ok(new JwtResponse(token));
		
	}
	


}
