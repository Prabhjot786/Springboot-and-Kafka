package com.loyalist.onlinemoviebookingsystem.service;


import java.util.List;

import com.loyalist.onlinemoviebookingsystem.dto.CinemaHall;
import com.loyalist.onlinemoviebookingsystem.response.CinemaHallResponseVO;

public interface ICinemaHall {

	String addCinemaHall(long cinemaId, CinemaHall cinemaHall);

	List<CinemaHallResponseVO> getCinemaHalls(long cinemaId);


}
