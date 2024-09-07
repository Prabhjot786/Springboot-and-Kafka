package com.loyalist.onlinemoviebookingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loyalist.onlinemoviebookingsystem.dao.CinemaHallRepository;
import com.loyalist.onlinemoviebookingsystem.dao.CinemaHallSeatRepository;
import com.loyalist.onlinemoviebookingsystem.dto.CinemaHall;
import com.loyalist.onlinemoviebookingsystem.dto.CinemaHallSeat;
import com.loyalist.onlinemoviebookingsystem.request.CinemaHallSeatRequestVO;

@Service
public class CinemaHallSeatImpl implements ICinemaHallSeat {

	@Autowired
	CinemaHallSeatRepository cinemaHallSeatRepository;
	
	@Autowired
	CinemaHallRepository cinemaHallRepository;

	@Override
	public String addCinemaHallSeat(long cinemaId, long cinemaHallId, CinemaHallSeatRequestVO cinemaHallSeatRequestVO) {

	
		CinemaHallSeat cinemaHallSeat = new CinemaHallSeat();
		//cinemaHallSeat.setSeatId(cinemaHallSeatRequestVO.getSeatId());
		cinemaHallSeat.setSeatRow(cinemaHallSeatRequestVO.getSeatRow());
		cinemaHallSeat.setSeatColumn(cinemaHallSeatRequestVO.getSeatColumn());
		cinemaHallSeat.setSeatType(cinemaHallSeatRequestVO.getSeatType());
		cinemaHallSeat.setSeatNumber(cinemaHallSeatRequestVO.getSeatColumn()+cinemaHallSeatRequestVO.getSeatRow());
 
		cinemaHallSeat.setCinemaHall(cinemaHallRepository.findById(cinemaHallId).get());
		
    	cinemaHallSeatRepository.save(cinemaHallSeat);
		return "seat added succcesfully";
	}

	@Override
	public List<CinemaHallSeat> getCinemaHallSeat(long cinemaId, long cinemaHallId) {
	
		CinemaHall cinemaHall=cinemaHallRepository.findCinemaHallByCinemaId(cinemaHallId,cinemaId);
		return cinemaHallSeatRepository.findCinemaHallSeatById(cinemaHall.getCinemaHallId());
		
		
	}

}
