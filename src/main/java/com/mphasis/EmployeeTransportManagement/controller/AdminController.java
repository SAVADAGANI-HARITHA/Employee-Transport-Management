package com.mphasis.EmployeeTransportManagement.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.EmployeeTransportManagement.model.Admin;
import com.mphasis.EmployeeTransportManagement.service.AdminService;


//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
@RestController
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@GetMapping("/login")
	public ResponseEntity<Object> validateAdmin(@RequestBody Admin admin) 		
	{
		Admin a = adminService.validateAdmin(admin);
		if (a==null)
		
		return new ResponseEntity<>("Invalid credentials",HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>("Successful login", HttpStatus.OK);
	}
}