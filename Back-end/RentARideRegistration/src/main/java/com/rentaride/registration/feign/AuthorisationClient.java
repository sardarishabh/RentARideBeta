package com.rentaride.registration.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "authorization-service", url = "${AUTH_SERVICE:http://localhost:8081}")
public interface AuthorisationClient {
	
	@GetMapping("/auth/validate")
	public boolean validate(@RequestHeader(name = "Authorization") String token);
	
	@PostMapping("/auth/user/{userName}/{password}")
	public ResponseEntity<String> addUser(@PathVariable String userName, @PathVariable String password);
}
