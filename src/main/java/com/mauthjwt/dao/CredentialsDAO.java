package com.mauthjwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mauthjwt.model.Credentials;

public interface CredentialsDAO extends JpaRepository<Credentials, Long> {
	
	Credentials findCredentialsByAlias(String alias);

}
