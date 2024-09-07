package com.loyalist.onlinemoviebookingsystem.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loyalist.onlinemoviebookingsystem.dao.CinemaHallRepository;
import com.loyalist.onlinemoviebookingsystem.dao.ICinemaRepository;
import com.loyalist.onlinemoviebookingsystem.dao.IMovieRepository;
import com.loyalist.onlinemoviebookingsystem.dao.IShowRepository;
import com.loyalist.onlinemoviebookingsystem.dto.Cinema;
import com.loyalist.onlinemoviebookingsystem.dto.CinemaHall;
import com.loyalist.onlinemoviebookingsystem.dto.Movie;
import com.loyalist.onlinemoviebookingsystem.dto.Show;
import com.loyalist.onlinemoviebookingsystem.exception.MovieNotFoundException;
import com.loyalist.onlinemoviebookingsystem.exception.ShowNotFoundException;
import com.loyalist.onlinemoviebookingsystem.request.ShowRequestVO;
import com.loyalist.onlinemoviebookingsystem.response.ShowResponseVO;
import com.loyalist.onlinemoviebookingsystem.validator.MovieValidator;
import com.loyalist.onlinemoviebookingsystem.validator.ShowValidator;

@Service
public class ShowService implements IShow {

	@Autowired
	IShowRepository showRepository;

	@Autowired
	ICinemaRepository cinemaRepository;

	@Autowired
	CinemaHallRepository cinemaHallRepository;

	@Autowired
	IMovieRepository movieRepository;

	@Autowired
	ShowValidator showValidator;

	@Autowired
	MovieValidator movieValidator;

	@Override
	public List<Show> getShows() {
		return showRepository.findAll();
	}

	@Override
	public String addShow(ShowRequestVO showRequestVO) {

		Cinema cinema = showValidator.validateCinemaId(showRequestVO.getCinemaId());
		CinemaHall cinemaHall = showValidator.validateCinemaHallId(showRequestVO.getCinemaHallId());
		Movie movie = showValidator.validateMovieName(showRequestVO.getMovieName());
		movieValidator.ValidateMovieReleaseDate(movie.getReleaseDate());
		Show show = new Show();
		show.setEndTime(showRequestVO.getShowEndTime());
		show.setStartTime(showRequestVO.getShowStartTime());
		show.setCreatedOn(LocalDate.now());
		show.setShowName(showRequestVO.getShowName());

		showValidator.validateShowTimePeriod(show.getStartTime(), show.getEndTime(), cinemaHall.getCinemaHallId());
		show.setMovie(movie);
		show.setCinema(cinema);
		show.setCinemaHall(cinemaHall);

		showRepository.save(show);

		return "Show Added Successfully";
	}

	@Override
	public List<ShowResponseVO> getShowsByMovieId(long movieId) {
		Movie movie = movieRepository.findById(movieId).get();
		if (movie == null) {
			throw new MovieNotFoundException("Movie with id" + movieId + " doesnot exist");
		}
		List<Show> shows = showRepository.findByMovieId(movieId);

		List<ShowResponseVO> showResponseVOs = new ArrayList<>();

		for (Show show : shows) {
			ShowResponseVO showResponseVO = new ShowResponseVO();
			showResponseVO.setCinemaHallId(show.getCinemaHall().getCinemaHallId());
			showResponseVO.setMovieName(show.getMovie().getTitle());
			showResponseVO.setCinemaId(show.getCinema().getCinemaId());
			showResponseVO.setShowCreatedOn(show.getCreatedOn());
			showResponseVO.setShowEndTime(show.getEndTime());
			showResponseVO.setShowStartTime(show.getStartTime());

			showResponseVOs.add(showResponseVO);
		}
		return showResponseVOs;
	}

	@Override
	public List<ShowResponseVO> getShowsByCinemaAndCinemaHall(long cinemaId, long cinemaHallId) {
		
		showValidator.validateCinemaId(cinemaId);
		showValidator.validateCinemaHallId(cinemaHallId);
		List<ShowResponseVO> showResponseVOs=new ArrayList<>();
		
		List<Show> shows=showRepository.findShowsByCinemaAndCinemaHall(cinemaId,cinemaHallId);
		for(Show show:shows) {
			ShowResponseVO showResponseVO=new ShowResponseVO();
			showResponseVO.setCinemaHallId(show.getCinemaHall().getCinemaHallId());
			showResponseVO.setMovieName(show.getMovie().getTitle());
			showResponseVO.setCinemaId(show.getCinema().getCinemaId());
			showResponseVO.setShowCreatedOn(show.getCreatedOn());
			showResponseVO.setShowEndTime(show.getEndTime());
			showResponseVO.setShowStartTime(show.getStartTime());
			showResponseVOs.add(showResponseVO);
		}
		return showResponseVOs;
	}

	@Override
	public Show getShowById(long showId) {
		Show show=showRepository.findById(showId).get();
		if(show==null) {
			throw new ShowNotFoundException("Show Doesn't exist");
		}
		
		return show;
	}
}
