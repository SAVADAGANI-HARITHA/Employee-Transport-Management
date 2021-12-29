package com.mphasis.EmployeeTransportManagement.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.EmployeeTransportManagement.dao.AdminRepository;
import com.mphasis.EmployeeTransportManagement.model.Admin;

@Service
public class AdminService {
	@Autowired
	AdminRepository adminRepository;
	public Admin validateAdmin(Admin admin) {
		Admin a=adminRepository.validateAdmin(admin.getUsername(),admin.getPassword());
		
		return a;
	}
}