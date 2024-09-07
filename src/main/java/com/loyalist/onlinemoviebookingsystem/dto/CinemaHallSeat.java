package com.loyalist.onlinemoviebookingsystem.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.loyalist.onlinemoviebookingsystem.constants.SeatType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;



@Entity
public class CinemaHallSeat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int seatId;
	private String seatRow;
	private int seatColumn;
	private String seatNumber;
	private double seatPrice;
	
	@Enumerated(EnumType.ORDINAL)
	private SeatType seatType;

	
	@ManyToOne
	@JoinColumn(name = "fk_CinemaHall")
	private CinemaHall cinemaHall;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cinemaHallSeats", cascade = CascadeType.ALL,targetEntity = ShowSeat.class)
	private List<ShowSeat> showSeats;
	
	public CinemaHallSeat() {
		// TODO Auto-generated constructor stub
	}
	public CinemaHallSeat(String seatRow, int seatColumn,String seatNumber,double seatPrice) {
		super();
		this.seatRow = seatRow;
		this.seatColumn = seatColumn;
		this.seatNumber=seatNumber;
		this.seatPrice=seatPrice;
	}

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
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	public List<ShowSeat> getShowSeats() {
		return showSeats;
	}
	public void setShowSeats(List<ShowSeat> showSeats) {
		this.showSeats = showSeats;
	}
	public double getSeatPrice() {
		return seatPrice;
	}
	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}
}