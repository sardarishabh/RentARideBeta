package com.rentaride.registration.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Handles registration null exception
	 * 
	 * @param ex
	 * @return This returns the custom error message and the time stamp and the HTTP
	 *         status code
	 */
	
	@ExceptionHandler(RegistrationException.class)
	public ResponseEntity<CustomErrorResponse> handlesRegistrationException(
			RegistrationException registrationException) {
		CustomErrorResponse response = new CustomErrorResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(registrationException.getMessage());

		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
