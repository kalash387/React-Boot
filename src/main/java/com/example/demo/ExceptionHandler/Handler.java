package com.example.demo.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.CustomExceptions.NotFoundException;

@RestControllerAdvice
public class Handler {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<String> handleException(
			NotFoundException exception
			)
	{
		return new ResponseEntity<String>
		(exception.getMessage(),HttpStatus.NOT_FOUND);
		
		
	}

}
