package com.mms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mms.entity.ErrorResponse;

@ControllerAdvice
public class MovieExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> customerNotFoundException(MovieNotFoundException e){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(e.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
		
	}
	
	
}