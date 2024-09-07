package com.loyalist.onlinemoviebookingsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.loyalist.onlinemoviebookingsystem.dto.CinemaHall;

public interface CinemaHallRepository extends JpaRepository<CinemaHall, Long> {

	@Query(value = "select * from cinema_hall_table where cinema_hall_id=:cinemaHallId AND fk_cinema_id=:cinemaId", nativeQuery = true)
	public CinemaHall findCinemaHallByCinemaId(@Param("cinemaHallId") Long cinemaHallId,@Param("cinemaId") Long cinemaId);

	@Query(value = "select *  from cinema_hall_table where fk_cinema_id=:cinemaId", nativeQuery = true)
	public List<CinemaHall> findCinemaHallByCinemaId(@Param("cinemaId") Long cinemaId);

	public CinemaHall findCinemaHallByCinemaHallId(long cinemaHallId);

	@Query("SELECT cinemaHall FROM CinemaHall cinemaHall WHERE cinemaHall.cinemaHallId=?1")
	public Optional<CinemaHall> findCinemaHallById(Long cinemaHallId);

	//@Query(value = "select ch  from CinemaHall ch where cinema.cinemaId=:cinemaId")
	//public List<CinemaHall> findCinemaHallByCinemaId2(@Param("cinemaId") Long cinemaId);

}
