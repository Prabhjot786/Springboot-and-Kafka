package com.loyalist.onlinemoviebookingsystem.request;

import com.loyalist.onlinemoviebookingsystem.constants.SeatType;
import com.loyalist.onlinemoviebookingsystem.dto.CinemaHall;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class CinemaHallSeatRequestVO {
	
	private int seatId;
	private String seatRow;
	private int seatColumn;
	private CinemaHall cinemaHall;
	private int seatNumber;
	
	@Enumerated(EnumType.ORDINAL)
	private SeatType seatType;
	
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public String getSeatRow() {
		return seatRow;
	}
	public void setSeatRow(String seatRow) {
		this.seatRow = seatRow;
	}
	public int getSeatColumn() {
		return seatColumn;
	}
	public void setSeatColumn(int seatColumn) {
		this.seatColumn = seatColumn;
	}
	public SeatType getSeatType() {
		return seatType;
	}
	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
	public CinemaHall getCinemaHall() {
		return cinemaHall;
	}
	public void setCinemaHall(CinemaHall cinemaHall) {
		this.cinemaHall = cinemaHall;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

}
