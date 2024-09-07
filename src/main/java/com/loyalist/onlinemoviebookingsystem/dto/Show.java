package com.loyalist.onlinemoviebookingsystem.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "ShowTable")
@Entity
public class Show {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long showId;
	private String showName;
	private LocalDate createdOn;
	private LocalDateTime startTime;
	private LocalDateTime endTime;

	@ManyToOne
	private Movie movie;

	@ManyToOne
	private Cinema cinema;

	@ManyToOne
	private CinemaHall cinemaHall;

	@JsonIgnore
	@OneToMany(mappedBy = "shows", cascade = CascadeType.ALL, targetEntity = ShowSeat.class)
	private List<ShowSeat> showSeats;

	@JsonIgnore
	@OneToMany(mappedBy = "show", cascade = CascadeType.ALL, targetEntity = Booking.class)
	private List<Booking> bookings;

	public Show() {

	}

	public Show(LocalDate createdOn, LocalDateTime startTime, LocalDateTime endTime, String showName) {
		super();
		this.createdOn = createdOn;
		this.startTime = startTime;
		this.endTime = endTime;
		this.showName = showName;
	}

	public long getShowId() {
		return showId;
	}

	public void setShowId(long showId) {
		this.showId = showId;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public CinemaHall getCinemaHall() {
		return cinemaHall;
	}

	public void setCinemaHall(CinemaHall cinemaHall) {
		this.cinemaHall = cinemaHall;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

}
