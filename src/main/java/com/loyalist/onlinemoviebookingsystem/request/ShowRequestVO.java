package com.loyalist.onlinemoviebookingsystem.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ShowRequestVO {
	
	private Long cinemaId;
	private Long cinemaHallId;
	private String movieName;
	private LocalDateTime showStartTime;
	private LocalDateTime showEndTime;
	private LocalDate showCreatedOn;
	private String showName;

	public Long getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(Long cinemaId) {
		this.cinemaId = cinemaId;
	}

	public Long getCinemaHallId() {
		return cinemaHallId;
	}

	public void setCinemaHallId(Long cinemaHallId) {
		this.cinemaHallId = cinemaHallId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public LocalDateTime getShowStartTime() {
		return showStartTime;
	}

	public void setShowStartTime(LocalDateTime showStartTime) {
		this.showStartTime = showStartTime;
	}

	public LocalDateTime getShowEndTime() {
		return showEndTime;
	}

	public void setShowEndTime(LocalDateTime showEndTime) {
		this.showEndTime = showEndTime;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public LocalDate getShowCreatedOn() {
		return showCreatedOn;
	}

	public void setShowCreatedOn(LocalDate showCreatedOn) {
		this.showCreatedOn = showCreatedOn;
	}

	
}
