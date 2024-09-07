package com.loyalist.onlinemoviebookingsystem.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String userName;
	private String userEmail;
	private Long userPhoneNumber;
	private String userPassword;
	@Pattern(regexp = "Male|Female|Others")
	private String userGender;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,targetEntity = Booking.class)
	private List<Booking> bookings;

	public User(Long userId,String userName, String userEmail, Long userPhoneNumber,
			String userPassword, String userGender) {
		super();
	
		this.userId=userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhoneNumber = userPhoneNumber;
		this.userPassword = userPassword;
		this.userGender = userGender;
	}


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Long getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(Long userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPhoneNumber="
				+ userPhoneNumber + ", userPassword=" + userPassword + ", userGender=" + userGender + ", bookings="
				+ bookings + "]";
	}


}
