package com.loyalist.onlinemoviebookingsystem.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name="CinemaTable")
@Entity
public class Cinema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cinemaId;	
	private String cinemaName;
	private int totalCinemaHalls;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_addressId")
	private Address location;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL,targetEntity = CinemaHall.class)
	private List<CinemaHall> cinemaHalls;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cinema",cascade = CascadeType.ALL,targetEntity = Show.class)
	private List<Show> shows;
	
	
	/*
	 * @JsonIgnore
	 * 
	 * @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL) private
	 * List<Cinema> cinema;
	 */
	public Cinema() {

	}
	public Cinema( String cinemaName, int totalCinemaHalls, Address location) {
		super();
		
		this.cinemaName = cinemaName;
		this.totalCinemaHalls = totalCinemaHalls;
		this.location = location;
	}
	public long getCinemaId() {
		return cinemaId;
	}
	public void setCinemaId(long cinemaId) {
		this.cinemaId = cinemaId;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	public int getTotalCinemaHalls() {
		return totalCinemaHalls;
	}
	public void setTotalCinemaHalls(int totalCinemaHalls) {
		this.totalCinemaHalls = totalCinemaHalls;
	}
	public Address getLocation() {
		return location;
	}
	public void setLocation(Address location) {
		this.location = location;
	}
	public List<CinemaHall> getCinemaHalls() {
		return cinemaHalls;
	}
	public void setCinemaHalls(List<CinemaHall> cinemaHalls) {
		this.cinemaHalls = cinemaHalls;
	}
	public List<Show> getShows() {
		return shows;
	}
	public void setShows(List<Show> shows) {
		this.shows = shows;
	}
}
