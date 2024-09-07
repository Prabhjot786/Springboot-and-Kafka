package com.loyalist.onlinemoviebookingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.loyalist.onlinemoviebookingsystem.dto.Cinema;

public interface ICinemaRepository extends JpaRepository<Cinema, Long> {

	Cinema findCinemaByCinemaId(long cinemaId);

	@Query("SELECT cinema FROM Cinema cinema WHERE cinema.cinemaId=?1")
	Cinema findByCinemaId(Long cinemaId);

}
