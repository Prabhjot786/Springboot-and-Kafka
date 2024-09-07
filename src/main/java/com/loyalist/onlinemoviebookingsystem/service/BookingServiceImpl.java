package com.loyalist.onlinemoviebookingsystem.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loyalist.onlinemoviebookingsystem.constants.BookingStatus;
import com.loyalist.onlinemoviebookingsystem.dao.CinemaHallSeatRepository;
import com.loyalist.onlinemoviebookingsystem.dao.IBookingRepository;
import com.loyalist.onlinemoviebookingsystem.dao.IUserRepository;
import com.loyalist.onlinemoviebookingsystem.dao.IShowRepository;
import com.loyalist.onlinemoviebookingsystem.dao.IShowSeatRepository;
import com.loyalist.onlinemoviebookingsystem.dto.Booking;
import com.loyalist.onlinemoviebookingsystem.dto.CinemaHallSeat;
import com.loyalist.onlinemoviebookingsystem.dto.Show;
import com.loyalist.onlinemoviebookingsystem.dto.ShowSeat;
import com.loyalist.onlinemoviebookingsystem.dto.User;

@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	IBookingRepository bookingRepository;

	@Autowired
	IUserRepository userRepository;

	@Autowired
	IShowRepository showRepository;

	@Autowired
	IShowSeatRepository showSeatRepository;

	@Autowired
	CinemaHallSeatRepository cinemaHallRepository;

	@Override
	public String addBooking(long userId, long showId, Booking booking) {

		User user = userRepository.findById(userId).get();
		Show show = showRepository.findById(showId).get();
		Booking bookingData = new Booking();
		bookingData.setPerson(user);
		bookingData.setShow(show);
		bookingData.setBookingStatus(booking.getBookingStatus());
		bookingData.setSeats(booking.getSeats());
		bookingData.setTimestamp(LocalDate.now());
		bookingRepository.save(bookingData);

		if (bookingData.getBookingStatus() == BookingStatus.booked) {
			List<String> list = new ArrayList<>(Arrays.asList(bookingData.getSeats()));
			for (String list1 : list) {
				ShowSeat showSeatData = new ShowSeat();
				showSeatData.setSeatNumber(list1);
				CinemaHallSeat cinemaHallSeat = cinemaHallRepository.findBySeatNumber(list1);
				showSeatData.setPrice(cinemaHallSeat.getSeatPrice());
				showSeatData.setShows(show);
				showSeatData.setBooking(bookingData);
				showSeatData.setCinemaHallSeats(cinemaHallSeat);
				showSeatData.setReserved(true);
				showSeatRepository.save(showSeatData);
			}
		}

		return "Booking Done";
	}

}
