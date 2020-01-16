package com.mauthjwt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class FirstController {
	
	@GetMapping("/hello")
	private String hello() {
		return "hello";
	}

}
