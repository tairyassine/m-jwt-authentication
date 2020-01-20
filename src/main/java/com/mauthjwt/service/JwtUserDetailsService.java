package com.mauthjwt.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mauthjwt.dao.CredentialsDAO;
import com.mauthjwt.dao.UserDAO;
import com.mauthjwt.model.Credentials;
import com.mauthjwt.model.UserDb;

@Service
public class JwtUserDetailsService implements UserDetailsService{
	
	@Autowired 
	private PasswordEncoder bcryptEncoder;
	
	@Autowired 
	private UserDAO userDao;
	
	@Autowired
	private CredentialsDAO credentialsDao;
		/***
		 * load user details from database
		 * */
	
	public UserDetails loadUserByUsername(String username) {
		UserDb utilisateur =null;
		if(username.contains("@")) {
			utilisateur = userDao.findUserByEmail(username);			
		}else {
			Credentials cr= credentialsDao.findCredentialsByAlias(username);
			utilisateur = cr.getUser();
		}
		if(utilisateur != null) {
			return new org.springframework.security.core.userdetails.User(utilisateur.getUserCredentials().getAlias(),bcryptEncoder.encode(utilisateur.getUserCredentials().getPassword()),
					new ArrayList<>());
		}
		return new org.springframework.security.core.userdetails.User("yas",bcryptEncoder.encode("123"),
				new ArrayList<>());
		//return (UserDetails) new User("yas","123");
	}
}
