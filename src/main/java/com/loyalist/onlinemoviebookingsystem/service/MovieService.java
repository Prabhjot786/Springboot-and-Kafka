package com.loyalist.onlinemoviebookingsystem.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loyalist.onlinemoviebookingsystem.dao.IMovieRepository;
import com.loyalist.onlinemoviebookingsystem.dto.Movie;
import com.loyalist.onlinemoviebookingsystem.exception.MovieAlreadyExistsException;
import com.loyalist.onlinemoviebookingsystem.validator.MovieValidator;

@Service
public class MovieService implements IMovie {

	@Autowired
	IMovieRepository movieRepository;
	
	@Autowired
	MovieValidator movieValidator;

	@Override
	public Movie addMovie(Movie movie) {
		Movie movieExists = movieRepository.findByTitle(movie.getTitle()).orElse(null);
		movieValidator.ValidateMovieReleaseDate(movie.getReleaseDate());
		if (movieExists == null) {
			movieRepository.save(movie);
			return movie;
		} else
	   throw new MovieAlreadyExistsException("Movie With Title:" + movieExists.getTitle() + " already exists");
	}

	@Override
	public List<Movie> getMovies() {
		return movieRepository.findAll();
	}

	@Override
	public Movie updateMovie(long movieId, Movie movie) {

		Movie movieFromDB = movieRepository.findById(movieId).orElseThrow(()
				-> new NoSuchElementException("No Movie Present with this movieId :"+ movieId));
		movie.setMovieId(movieFromDB.getMovieId());
		movieValidator.ValidateMovieReleaseDate(movie.getReleaseDate());
		movieRepository.save(movie);
		return movie;
	}

	@Override
	public List<Movie> deleteMovie(long movieId) {
		Movie movie= movieRepository.findById(movieId).orElseThrow(()-> new NoSuchElementException("No Movie Present with this movieId:"+movieId));
		movieRepository.delete(movie);
		return movieRepository.findAll();
	}

}
