package com.loyalist.onlinemoviebookingsystem.service;

import java.util.List;

import com.loyalist.onlinemoviebookingsystem.dto.Movie;

public interface IMovie {
	
	Movie addMovie(Movie movie);
	List<Movie> getMovies();
	Movie updateMovie(long movieId, Movie movie);
	List<Movie> deleteMovie(long movieId);

}
