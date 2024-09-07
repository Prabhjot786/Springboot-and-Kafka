package com.loyalist.onlinemoviebookingsystem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loyalist.onlinemoviebookingsystem.dto.User;

public interface IUserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUserEmail(String userEmail);

	Optional<User> findByUserName(String userName);
	
	

}
