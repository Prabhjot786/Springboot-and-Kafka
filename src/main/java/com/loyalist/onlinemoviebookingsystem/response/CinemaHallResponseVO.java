package com.loyalist.onlinemoviebookingsystem.response;

public class CinemaHallResponseVO {
	
	private long cinemaHallId;
	private String cinemaHallName;
	private int totalSeats;
	
	public long getCinemaHallId() {
		return cinemaHallId;
	}
	public void setCinemaHallId(long cinemaHallId) {
		this.cinemaHallId = cinemaHallId;
	}
	public String getCinemaHallName() {
		return cinemaHallName;
	}
	public void setCinemaHallName(String cinemaHallName) {
		this.cinemaHallName = cinemaHallName;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

}
