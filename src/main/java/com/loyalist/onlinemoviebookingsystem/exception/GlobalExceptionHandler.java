package com.loyalist.onlinemoviebookingsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ RuntimeException.class })
	public ResponseEntity<ErrorDetails> handleException(RuntimeException exception) {
		return new ResponseEntity<ErrorDetails>(new ErrorDetails(exception.getMessage(), HttpStatus.BAD_REQUEST),
				HttpStatus.BAD_REQUEST);
	}

}
