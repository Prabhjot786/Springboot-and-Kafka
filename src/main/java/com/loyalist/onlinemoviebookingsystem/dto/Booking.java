package com.loyalist.onlinemoviebookingsystem.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.loyalist.onlinemoviebookingsystem.constants.BookingStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingId;
	private String [] seats;
	private LocalDate timestamp;
	
	@Enumerated(EnumType.ORDINAL)
	private BookingStatus bookingStatus;
	
	@JsonIgnore
	@OneToMany(mappedBy = "booking",cascade = CascadeType.ALL,targetEntity = ShowSeat.class)
	private List<ShowSeat> showSeats;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_personId")
	private User user;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_ShowId")
	private Show show;
	
	public Booking() {
	}
	
	public Booking( String[] seats, LocalDate timestamp) {
		super();
		this.seats = seats;
		this.timestamp = timestamp;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String[] getSeats() {
		return seats;
	}

	public void setSeats(String[] seats) {
		this.seats = seats;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}

	

	public List<ShowSeat> getShowSeats() {
		return showSeats;
	}

	public void setShowSeats(List<ShowSeat> showSeats) {
		this.showSeats = showSeats;
	}

	public User getPerson() {
		return user;
	}

	public void setPerson(User user) {
		this.user = user;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
}
