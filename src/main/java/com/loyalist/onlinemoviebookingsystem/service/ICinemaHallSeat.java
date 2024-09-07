package com.loyalist.onlinemoviebookingsystem.service;

import java.util.List;

import org.springframework.http.HttpStatusCode;

import com.loyalist.onlinemoviebookingsystem.dto.CinemaHallSeat;
import com.loyalist.onlinemoviebookingsystem.request.CinemaHallSeatRequestVO;

public interface ICinemaHallSeat {

	String addCinemaHallSeat(long cinemaId, long cinemaHallId, CinemaHallSeatRequestVO cinemaHallSeatRequestVO);

	List<CinemaHallSeat> getCinemaHallSeat(long cinemaId, long cinemaHallId);

}
