package com.loyalist.onlinemoviebookingsystem.service;

import java.util.List;

import com.loyalist.onlinemoviebookingsystem.dto.Show;
import com.loyalist.onlinemoviebookingsystem.request.ShowRequestVO;
import com.loyalist.onlinemoviebookingsystem.response.ShowResponseVO;

public interface IShow {

	// String addShow(long movieId, long cinemaId, long cinemaHallId, Show show);

	List<Show> getShows();
	String addShow(ShowRequestVO showRequestVO);
	List<ShowResponseVO> getShowsByMovieId(long movieId);
	List<ShowResponseVO> getShowsByCinemaAndCinemaHall(long cinemaId, long cinemaHallId);
	Show getShowById(long showId);

}
