package com.rentaride.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rentaride.registration.feign.AuthorisationClient;
import com.rentaride.registration.model.Register;
import com.rentaride.registration.service.RegistrationService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class RegistrationController {
	
	@Autowired
	RegistrationService registrationService;
	
	@Autowired
	AuthorisationClient authClient;
	
	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<>("Registration Ok", HttpStatus.OK);
	}
	
	@PostMapping("/register-user")
	public ResponseEntity<String> registerUser(@RequestBody Register user) {
		log.info(user.getEmail() + " : " + user.getPassword());
		authClient.registerUser(user.getEmail(), user.getPassword());
		
		registrationService.registerUser(user);
		return new ResponseEntity<String>("Inserted", HttpStatus.CREATED);
	}
}
