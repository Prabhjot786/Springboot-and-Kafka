package com.loyalist.onlinemoviebookingsystem.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.loyalist.onlinemoviebookingsystem.dto.Show;

public interface IShowRepository extends JpaRepository<Show, Long> {

	@Query("SELECT s from Show s WHERE ((s.startTime <= :startTime AND s.endTime >=:startTime)"
			+ " OR (s.startTime <= :endTime AND s.endTime >=:endTime)"
			+ "OR (s.startTime >= :startTime AND s.endTime <=:endTime))"
			+ "AND s.cinemaHall.cinemaHallId = :cinemaHallId ")
	List<Show> ShowsOverlapping(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime,
			@Param("cinemaHallId") Long cinemaHallId);


    @Query(value="select * from show_table where movie_movie_id=?1",nativeQuery=true)
	List<Show> findByMovieId(Long movieId);


    @Query(value="select * from show_table where cinema_cinema_id=?1 AND cinema_hall_cinema_hall_id=?2",nativeQuery=true)
	List<Show> findShowsByCinemaAndCinemaHall(long cinemaId, long cinemaHallId);
}
