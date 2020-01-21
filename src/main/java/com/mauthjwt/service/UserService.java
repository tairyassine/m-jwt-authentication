package com.mauthjwt.service;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauthjwt.dao.UserDAO;
import com.mauthjwt.envelope.request.RegistrationRequest;
import com.mauthjwt.model.Credentials;
import com.mauthjwt.model.UserDb;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public void saveUser(RegistrationRequest registrationRequest) throws PersistenceException {
		UserDb user = new UserDb();
		Credentials uc = new Credentials();
		user.setEmail(registrationRequest.getEmail());
		user.setFirstName(registrationRequest.getFirstName());
		user.setLastName(registrationRequest.getLastName());
		uc.setPassword(registrationRequest.getPassword());
		uc.setAlias(registrationRequest.getAlias());
		user.setUserCredentials(uc);
		uc.setUser(user);
		
		userDAO.save(user);
	}

}
