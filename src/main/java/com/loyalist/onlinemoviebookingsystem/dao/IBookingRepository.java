package com.loyalist.onlinemoviebookingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loyalist.onlinemoviebookingsystem.dto.Booking;

public interface IBookingRepository extends JpaRepository<Booking, Long> {
}
