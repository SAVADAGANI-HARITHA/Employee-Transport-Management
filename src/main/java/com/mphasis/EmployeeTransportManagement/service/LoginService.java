package com.mphasis.EmployeeTransportManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.EmployeeTransportManagement.dao.LoginRepository;
import com.mphasis.EmployeeTransportManagement.model.User;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;

	public User validateUser(User user) {
		User u=loginRepository.validateUser(user.getUserName(),user.getPassword());
		
		return u;
	}
	
}