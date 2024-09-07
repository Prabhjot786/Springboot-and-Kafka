package com.loyalist.onlinemoviebookingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loyalist.onlinemoviebookingsystem.dao.IUserRepository;
import com.loyalist.onlinemoviebookingsystem.request.AuthRequest;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

	@Autowired
	IUserRepository userRepository;

	@Autowired
	JWTService jwtService;

	@Override
	public String signin(AuthRequest authRequest) {
		// TODO Auto-generated method stub
		return null;
	}


}
