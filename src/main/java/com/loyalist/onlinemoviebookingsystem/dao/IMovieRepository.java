package com.loyalist.onlinemoviebookingsystem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loyalist.onlinemoviebookingsystem.dto.Movie;


public interface IMovieRepository extends JpaRepository<Movie,Long>{

	Movie findMovieByMovieId(long movieId);
	
	Optional<Movie> findByTitle(String title);


	
	

}
