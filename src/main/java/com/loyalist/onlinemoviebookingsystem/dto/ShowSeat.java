package com.loyalist.onlinemoviebookingsystem.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ShowSeat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int showSeatId;
	private String seatNumber;
	private boolean isReserved;
	private double price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_Booking_id")
	private Booking booking;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name="fk_Show_ShowId")
	private Show shows;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_cinemaHallSeat_id")
	private CinemaHallSeat cinemaHallSeats;
	
	
	public ShowSeat() {
		// TODO Auto-generated constructor stub
	}
	
	public ShowSeat(String seatNumber, boolean isReserved, double price) {
		super();
		this.seatNumber = seatNumber;
		this.isReserved = isReserved;
		this.price = price;
	}
	public int getShowSeatId() {
		return showSeatId;
	}
	public void setShowSeatId(int showId) {
		this.showSeatId = showId;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public boolean isReserved() {
		return isReserved;
	}
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Show getShows() {
		return shows;
	}

	public void setShows(Show shows) {
		this.shows = shows;
	}

	public CinemaHallSeat getCinemaHallSeats() {
		return cinemaHallSeats;
	}

	public void setCinemaHallSeats(CinemaHallSeat cinemaHallSeats) {
		this.cinemaHallSeats = cinemaHallSeats;
	}
	

}
