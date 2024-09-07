package com.loyalist.onlinemoviebookingsystem.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loyalist.onlinemoviebookingsystem.dao.ICinemaRepository;
import com.loyalist.onlinemoviebookingsystem.dto.Address;
import com.loyalist.onlinemoviebookingsystem.dto.Cinema;

@Service
public class CinemaService implements ICinema {

	@Autowired
	ICinemaRepository cinemaRepository;

	@Override
	public String addCinema(Cinema cinema) {
		cinemaRepository.save(cinema);
		return "cinema added successfully";
	}

	@Override
	public List<Cinema> getCinemas() {
		return cinemaRepository.findAll();
	}

	@Override
	public Cinema getCinemaByCinemaId(long cinemaId) {
		Cinema cinema = cinemaRepository.findById(cinemaId)
				.orElseThrow(() -> new NoSuchElementException("No Cinema Present With this CinemaId" + cinemaId));
		return cinema;
	}

	@Override
	public String updateCinemaDetails(long cinemaId, Cinema cinema) {
		Cinema cinemaFromDB = cinemaRepository.findById(cinemaId)
				.orElseThrow(() -> new NoSuchElementException("No Cinema Present With this CinemaId" + cinemaId));

		Address address = new Address();
		address.setId(cinema.getLocation().getId());
		address.setCity(cinema.getLocation().getCity());
		address.setState(cinema.getLocation().getState());
		address.setCountry(cinema.getLocation().getCountry());
		address.setStreetAddress(cinema.getLocation().getStreetAddress());
		address.setZipcode(cinema.getLocation().getZipcode());

		cinemaFromDB.setCinemaName(cinema.getCinemaName());
		cinemaFromDB.setLocation(address);
		cinemaFromDB.setTotalCinemaHalls(cinema.getTotalCinemaHalls());

		cinemaRepository.save(cinemaFromDB);
		return "Cinema has been Updated Successfully";
	}
}
