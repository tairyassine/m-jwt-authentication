package com.mauthjwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauthjwt.model.Profil;

@Repository
public interface ProfilDAO extends JpaRepository<Profil, Long> {

}
