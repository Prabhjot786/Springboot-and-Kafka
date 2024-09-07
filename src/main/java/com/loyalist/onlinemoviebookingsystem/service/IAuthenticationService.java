package com.loyalist.onlinemoviebookingsystem.service;

import com.loyalist.onlinemoviebookingsystem.request.AuthRequest;

public interface IAuthenticationService {
	
  String signin(AuthRequest authRequest);

}
