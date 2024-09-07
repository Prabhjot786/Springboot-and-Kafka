package com.loyalist.onlinemoviebookingsystem.validator;

public class CinemaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	CinemaNotFoundException(String message) {
		super(message);
	}

}
