package com.mauthjwt.controller;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mauthjwt.envelope.request.JwtRequest;
import com.mauthjwt.envelope.request.RegistrationRequest;
import com.mauthjwt.envelope.response.CommunResultDTO;
import com.mauthjwt.envelope.response.ErrorDetailDTO;
import com.mauthjwt.envelope.response.JwtResponse;
import com.mauthjwt.envelope.response.MessageDTO;
import com.mauthjwt.envelope.response.ReponseDTO;
import com.mauthjwt.facade.JwtAuthenticationProcess;
import com.mauthjwt.service.UserService;
import com.mauthjwt.util.Constantes;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
	  Logger logger = LoggerFactory.getLogger(JwtAuthenticationController.class);
	
	@Autowired
	private JwtAuthenticationProcess jwtAuthenticationProcess;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;

	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authenticationRequest){
		ReponseDTO reponseDTO = new ReponseDTO();
		String token=null;
		String userCredential = null;
		try {
			if(!StringUtils.isEmpty(authenticationRequest.getAlias())) {
				userCredential= authenticationRequest.getAlias();
			}else {
				userCredential= authenticationRequest.getUserEmail();
			}
			authenticate(userCredential,
					authenticationRequest.getPassword());
			
			final UserDetails userDetails = jwtAuthenticationProcess.loadUser(userCredential);
			token = jwtAuthenticationProcess.generateToken(userDetails);
			reponseDTO.setStatus(200);
			reponseDTO.getSuccess().add(new MessageDTO(authenticationRequest.getUserEmail(),
					"authentication with success", null));
			logger.info("generated token => "+token);
		}catch(Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.badRequest().body("an internal error occurred during the authentication attempt");
		}
		
		
		return ResponseEntity.ok(new CommunResultDTO(reponseDTO, new JwtResponse(token)));
		
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
	

	@RequestMapping(value = "/register", method = RequestMethod.POST,
	produces = { "application/json" })
	public ResponseEntity<?> register(@RequestBody RegistrationRequest registrationRequest){
		ReponseDTO reponseDTO = new ReponseDTO();
		logger.info("registration started");
		List<ErrorDetailDTO> errorsDetails = new ArrayList<ErrorDetailDTO>();
		try {
			userService.saveUser(registrationRequest);			
		}catch(Exception e) {
			errorsDetails.add(new ErrorDetailDTO(Constantes.CODE_ERROR_ERREUR_FONCTIONNELLE,
					"a functional error occured during the registration attempt" + ", " + e.getMessage()));
			MessageDTO errorDto = new MessageDTO(registrationRequest.getEmail(),
					"an error occured during the registration attempt",
					errorsDetails);
			reponseDTO.getErrors().add(errorDto);
			return ResponseEntity.badRequest().body(reponseDTO);
		}
		reponseDTO.setStatus(200);
		reponseDTO.getSuccess().add(new MessageDTO(registrationRequest.getEmail(),
				"user created with success", null));
		return ResponseEntity.ok().body(reponseDTO);
	}
	


}
