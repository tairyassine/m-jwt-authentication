package com.mauthjwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauthjwt.model.UserDb;

@Repository
public interface UserDAO extends JpaRepository<UserDb , Long> {
	
	UserDb findUserByEmail(String email);

}
