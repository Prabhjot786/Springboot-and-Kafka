package com.loyalist.onlinemoviebookingsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loyalist.onlinemoviebookingsystem.dao.CinemaHallRepository;
import com.loyalist.onlinemoviebookingsystem.dao.ICinemaRepository;
import com.loyalist.onlinemoviebookingsystem.dto.Cinema;
import com.loyalist.onlinemoviebookingsystem.dto.CinemaHall;
import com.loyalist.onlinemoviebookingsystem.response.CinemaHallResponseVO;

@Service
public class CinemaHallService implements ICinemaHall {

	@Autowired
	CinemaHallRepository cinemaHallRepository;

	@Autowired
	ICinemaRepository cinemaRepository;

	@Override
	public String addCinemaHall(long cinemaId, CinemaHall cinemaHallDetails) {
		Cinema cinema = cinemaRepository.findById(cinemaId).orElseThrow(()->
		new NoSuchElementException("No Such Cinema With CinemaId Exists"+cinemaId));
		cinemaHallDetails.setCinema(cinema);
		cinemaHallRepository.save(cinemaHallDetails);
		return "CinemaHall Added";
	}

	@Override
	public List<CinemaHallResponseVO> getCinemaHalls(long cinemaId) {
		List<CinemaHall> cinemaHalls = cinemaHallRepository.findCinemaHallByCinemaId(cinemaId);
		List<CinemaHallResponseVO> cinemaHallResponseVOs = new ArrayList<>();
		for (CinemaHall cinemaHall : cinemaHalls) {
			CinemaHallResponseVO cineHallResponseVO = new CinemaHallResponseVO();
			cineHallResponseVO.setCinemaHallId(cinemaHall.getCinemaHallId());
			cineHallResponseVO.setCinemaHallName(cinemaHall.getCinemaHallName());
			cineHallResponseVO.setTotalSeats(cinemaHall.getTotalSeats());
			cinemaHallResponseVOs.add(cineHallResponseVO);
    	}
		return cinemaHallResponseVOs;
	}	
}
