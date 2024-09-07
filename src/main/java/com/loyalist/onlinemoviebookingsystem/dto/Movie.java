package com.loyalist.onlinemoviebookingsystem.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "Movie")
@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long movieId;
	private String title;
	private String description;
	private int durationMins;
	private String[] language;
	private LocalDateTime releaseDate;
	private String country;
	private String genere;
	
	
	public Movie() {
	
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "movie",cascade = CascadeType.ALL,targetEntity = Show.class)
	private List<Show> shows;
	
	public Movie(String title, String description, int durationMins,String[] language,
			LocalDateTime releaseDate, String country, String genere) {
		super();
		this.title = title;
		this.description = description;
		this.durationMins = durationMins;
		this.language = language;
		this.releaseDate = releaseDate;
		this.country = country;
		this.genere = genere;
	}
	public long getMovieId() {
		return movieId;
	}
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDurationMins() {
		return durationMins;
	}
	public void setDurationMins(int durationMins) {
		this.durationMins = durationMins;
	}

	public LocalDateTime getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDateTime releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public List<Show> getShows() {
		return shows;
	}
	
	@JsonIgnore
	public void setShows(List<Show> shows) {
		this.shows = shows;
	}
	public String[] getLanguage() {
		return language;
	}

	public void setLanguage(String[] language) {
		this.language = language;
	}
	
}
