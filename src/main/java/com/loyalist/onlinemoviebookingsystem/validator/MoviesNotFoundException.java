package com.loyalist.onlinemoviebookingsystem.validator;

public class MoviesNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	MoviesNotFoundException(String message) {
		super(message);
	}

}
