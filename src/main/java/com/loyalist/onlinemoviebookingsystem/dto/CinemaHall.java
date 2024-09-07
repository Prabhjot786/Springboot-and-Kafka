package com.loyalist.onlinemoviebookingsystem.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "cinemaHallTable")
public class CinemaHall {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cinemaHallId;
	private String cinemaHallName;
	private int totalSeats;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_cinemaId")
	private Cinema cinema;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "cinemaHall",targetEntity = CinemaHallSeat.class)
	private List<CinemaHallSeat> cinemaHallSeats;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "cinemaHall",targetEntity = Show.class)
	private List<Show> shows;

	public CinemaHall() {
    //default constructor
	}
	public CinemaHall(String cinemaHallName, int totalSeats, List<CinemaHallSeat> cinemaHallSeats, Cinema cinema) {
		super();
		this.cinemaHallName = cinemaHallName;
		this.totalSeats = totalSeats;
		this.cinemaHallSeats = cinemaHallSeats;
		this.cinema=cinema;
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

	public List<CinemaHallSeat> getCinemaHallSeats() {
		return cinemaHallSeats;
	}

	public void setCinemaHallSeats(List<CinemaHallSeat> cinemaHallSeats) {
		this.cinemaHallSeats = cinemaHallSeats;
	}
	public long getCinemaHallId() {
		return cinemaHallId;
	}
	public void setCinemaHallId(long cinemaHallId) {
		this.cinemaHallId = cinemaHallId;
	}
	
	public Cinema getCinema() {
		return cinema;
	}
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	public List<Show> getShows() {
		return shows;
	}
	public void setShows(List<Show> shows) {
		this.shows = shows;
	}
	
}
