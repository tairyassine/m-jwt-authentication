package com.mauthjwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mauthjwt.dao.UserDAO;
import com.mauthjwt.model.UserDb;

@RestController
@CrossOrigin
public class FirstController {
	
	@Autowired
	private UserDAO userDAO;
	
	@GetMapping("/hello")
	private String hello() {
		return "hello";
	}
	
	@GetMapping("/users")
	private List<UserDb> retreiveUsers() {
		return userDAO.findAll();
	}

}
