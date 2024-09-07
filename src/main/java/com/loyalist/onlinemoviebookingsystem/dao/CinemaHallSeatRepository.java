package com.loyalist.onlinemoviebookingsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.loyalist.onlinemoviebookingsystem.dto.CinemaHall;
import com.loyalist.onlinemoviebookingsystem.dto.CinemaHallSeat;

public interface CinemaHallSeatRepository extends JpaRepository<CinemaHallSeat, Long> {

	
	@Query(value = "select * from cinema_hall_seat where fk_cinema_hall=:cinemaHallId", nativeQuery = true)
	public List<CinemaHallSeat> findCinemaHallSeatById(@Param("cinemaHallId") Long cinemaHallId);

	@Query(value = "select * from cinema_hall_seat where seat_number=:seatNumber", nativeQuery = true)
	public CinemaHallSeat findBySeatNumber(@Param("seatNumber") String seatNumber);
}

