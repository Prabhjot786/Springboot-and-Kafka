package com.loyalist.onlinemoviebookingsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loyalist.onlinemoviebookingsystem.dto.User;

@Service
public interface UserDetailsService {

	String addUser(User person);

	List<User> getUsers();

	User getUserById(long userId);

	User updateUser(long userId, User user);

}
