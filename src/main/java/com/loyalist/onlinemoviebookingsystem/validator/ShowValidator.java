package com.loyalist.onlinemoviebookingsystem.validator;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.loyalist.onlinemoviebookingsystem.dao.CinemaHallRepository;
import com.loyalist.onlinemoviebookingsystem.dao.ICinemaRepository;
import com.loyalist.onlinemoviebookingsystem.dao.IMovieRepository;
import com.loyalist.onlinemoviebookingsystem.dao.IShowRepository;
import com.loyalist.onlinemoviebookingsystem.dto.Cinema;
import com.loyalist.onlinemoviebookingsystem.dto.CinemaHall;
import com.loyalist.onlinemoviebookingsystem.dto.Movie;
import com.loyalist.onlinemoviebookingsystem.dto.Show;
import com.loyalist.onlinemoviebookingsystem.exception.InValidDataEntryException;
import com.loyalist.onlinemoviebookingsystem.exception.ShowOverlapException;

@Component
public class ShowValidator {

	@Autowired
	ICinemaRepository cinemaRepository;

	@Autowired
	CinemaHallRepository cinemaHallRepository;

	@Autowired
	IMovieRepository movieRepository;

	@Autowired
	IShowRepository showRepository;

	public Cinema validateCinemaId(long cinemaId) throws CinemaNotFoundException {

		Cinema cinema = cinemaRepository.findByCinemaId(cinemaId);
		if (cinema == null) {
			throw new CinemaNotFoundException("Cinema With Id" + " " + cinemaId + "doesn't exist");
		}
		return cinema;

	}

	public CinemaHall validateCinemaHallId(long cinemaHallId) throws CinemaHallNotFoundException {
		return cinemaHallRepository.findCinemaHallById(cinemaHallId).orElseThrow(
				() -> new CinemaHallNotFoundException("CinemaHall With Id" + " " + cinemaHallId + "doesn't exist"));
	}

	public Movie validateMovieName(String movieName) throws MoviesNotFoundException {
		Movie movie = movieRepository.findByTitle(movieName).get();
		if (movie == null) {
			throw new MoviesNotFoundException("Movie with name" + " " + movieName + " " + "Not Found");
		}
		return movie;
	}

	public void validateShowTimePeriod(LocalDateTime startTime, LocalDateTime endTime, Long CinemaHallId)
			throws ShowOverlapException {

		if (!endTime.isAfter(startTime) || startTime.isBefore(LocalDateTime.now())) {
			throw new InValidDataEntryException("Please Enter Valid Show End Time");
		}

		List<Show> showsOverlappedList = showRepository.ShowsOverlapping(startTime, endTime, CinemaHallId);
		if (!showsOverlappedList.isEmpty()) {
			throw new ShowOverlapException(
					"Show Already booked in this time Period.\" + \"Please Select the Start time and End time again.\"");
		}
	}
}
