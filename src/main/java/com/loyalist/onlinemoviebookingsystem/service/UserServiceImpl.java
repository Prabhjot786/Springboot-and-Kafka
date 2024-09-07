package com.loyalist.onlinemoviebookingsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.loyalist.onlinemoviebookingsystem.dao.IUserRepository;
import com.loyalist.onlinemoviebookingsystem.dto.User;
import com.loyalist.onlinemoviebookingsystem.exception.UserAlreadyExistsException;

@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	IUserRepository userRepository;

	@Lazy
	@Autowired
	private PasswordEncoder passwordEncoder;

	public String addUser(User user) {

		User userExists = userRepository.findByUserEmail(user.getUserEmail()).orElse(null);
		if (userExists == null) {

			user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
			userRepository.save(user);
			return "User Created Successfully";
		} else
			throw new UserAlreadyExistsException("User Already Exist with email id as:" + user.getUserEmail());
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public User getUserById(long userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new NoSuchElementException("No User Present with id :" + userId));
	}

	public User updateUser(long userId, User user) {

		User userExists = userRepository.findById(userId).orElse(null);
		if (userExists != null) {
			userExists.setUserEmail(user.getUserEmail());
			userExists.setUserGender(user.getUserGender());
			userExists.setUserName(user.getUserName());
			userExists.setUserPassword(user.getUserPassword());
			userExists.setUserPhoneNumber(user.getUserPhoneNumber());
			userRepository.save(userExists);

			return userExists;
		} else
			throw new NoSuchElementException("No User Present with Id :" + userId);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUserName(username).orElse(null);
		if (user == null) {
			throw new UsernameNotFoundException("No user with this user name");
		}
		return org.springframework.security.core.userdetails.User.builder().username(user.getUserName())
				.password(user.getUserPassword()).authorities(new ArrayList<>()) // Add roles or authorities as needed
				.build();
	}

}
