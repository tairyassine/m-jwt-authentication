package com.mauthjwt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mauthjwt.dao.ProfilDAO;
import com.mauthjwt.dao.UserDAO;
import com.mauthjwt.envelope.request.ProfilRequest;
import com.mauthjwt.model.Profil;
import com.mauthjwt.model.UserDb;

@RestController
@CrossOrigin
public class FirstController {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private ProfilDAO profilDAO;
	
	@GetMapping("/hello")
	private String hello() {
		return "hello";
	}
	
	@GetMapping("/users")
	private List<UserDb> retreiveUsers() {
		return userDAO.findAll();
	}
	
	@GetMapping("/user_profil")
	private Profil retreiveProfil(@RequestParam Long id) {
		Optional<Profil> p= profilDAO.findById(id);
		if(p.isPresent()) {
			return p.get();
		}

		return null;
	}
	
	@PostMapping("user_profil")
	private void saveUserProfil(@RequestBody ProfilRequest profil) {
		Profil pf = new Profil(profil.getCodeTypeUser(),profil.getLibelle());
		profilDAO.save(pf);
	}

}
