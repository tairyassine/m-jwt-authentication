package com.mauthjwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mauthjwt.model.UserDb;

public interface UserDAO extends JpaRepository<UserDb , Long> {
	
	UserDb findUserByEmail(String email);

}
