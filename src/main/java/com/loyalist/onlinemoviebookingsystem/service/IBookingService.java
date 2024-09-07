package com.loyalist.onlinemoviebookingsystem.service;

import com.loyalist.onlinemoviebookingsystem.dto.Booking;

public interface IBookingService {

	String addBooking(long userId, long showId, Booking booking);
	
	

}
