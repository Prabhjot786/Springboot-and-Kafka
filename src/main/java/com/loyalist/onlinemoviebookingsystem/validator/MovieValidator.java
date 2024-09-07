package com.loyalist.onlinemoviebookingsystem.validator;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.loyalist.onlinemoviebookingsystem.exception.InValidDataEntryException;

@Component
public class MovieValidator {
	public void ValidateMovieReleaseDate(LocalDateTime releaseDate) throws InValidDataEntryException {
		if (releaseDate.isBefore(LocalDateTime.now())) {
			throw new InValidDataEntryException("Please enter valid releaseDate of Movie");
		}
	}
}
