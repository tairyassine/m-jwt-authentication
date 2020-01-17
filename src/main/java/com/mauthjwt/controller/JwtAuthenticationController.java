package com.mauthjwt.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mauthjwt.facade.JwtAuthenticationProcess;
import com.mauthjwt.model.JwtRequest;
import com.mauthjwt.model.JwtResponse;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
	  Logger logger = LoggerFactory.getLogger(JwtAuthenticationController.class);
	
	@Autowired
	private JwtAuthenticationProcess jwtAuthenticationProcess;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authenticationRequest){
		String token=null;
		try {
			
			authenticate(authenticationRequest.getUsername(),
					authenticationRequest.getPassword());
			
			final UserDetails userDetails = jwtAuthenticationProcess.loadUser(authenticationRequest.getUsername());
			token = jwtAuthenticationProcess.generateToken(userDetails);
			logger.info("generated token => "+token);
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return ResponseEntity.ok(new JwtResponse(token));
		
	}
	
	/*private void authenticate(String username, String password) throws Exception {
		try {
			jwtAuthenticationProcess.authenticate(username, password);
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}*/
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	


}
