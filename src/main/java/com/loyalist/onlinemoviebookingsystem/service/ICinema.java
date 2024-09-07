package com.loyalist.onlinemoviebookingsystem.service;

import java.util.List;

import com.loyalist.onlinemoviebookingsystem.dto.Cinema;

public interface ICinema {

	String addCinema(Cinema cinema);

	List<Cinema> getCinemas();

	Cinema getCinemaByCinemaId(long cinemaId);

	String updateCinemaDetails(long cinemaId, Cinema cinema);

}
