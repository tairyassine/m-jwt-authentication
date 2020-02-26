package com.mauthjwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauthjwt.model.Credentials;

@Repository
public interface CredentialsDAO extends JpaRepository<Credentials, Long> {
	
	Credentials findCredentialsByAlias(String alias);

}
