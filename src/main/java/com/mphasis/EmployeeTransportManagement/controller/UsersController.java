package com.mphasis.EmployeeTransportManagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.tags.form.PasswordInputTag;

import com.mphasis.EmployeeTransportManagement.dao.UserRepository;
import com.mphasis.EmployeeTransportManagement.exception.ResourceNotFoundException;
import com.mphasis.EmployeeTransportManagement.model.Users;
import com.mphasis.EmployeeTransportManagement.service.UserDetailsService;


//@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1")
@RestController
public class UsersController {

	@Autowired
	UserDetailsService userService;

//http://localhost:9080/api/v1/getAllUsers
	@GetMapping("/getAllUsers")
	public List<Users> getUsers() {
		List<Users> userList = userService.fetchUsers();

		return userList;

	}

	// http://localhost:9080/api/v1/getUser/1
	@GetMapping("/getUser/{UserId}")
	public ResponseEntity<Users> getUsersById(@PathVariable("UserId") int userId)
			throws ResourceNotFoundException {
		Users users = userService.getUsers(userId);
		return ResponseEntity.ok().body(users);
	}

	// http://localhost:9080/api/v1/saveUsers
	@PostMapping("/saveUsers")
	public Users addUsers(@RequestBody Users users) {

		Users user = userService.saveUsers(users);

		 //return new ResponseEntity<>("Employee added successsfully", HttpStatus.OK);
		return users;
	}

	// http://localhost:9080/api/v1/updateUsers/2
	@PutMapping("/updateUsers/{id}")
	public ResponseEntity<Users> updateUsers(@PathVariable("id") int usersId,
			@RequestBody Users usersDetails) throws ResourceNotFoundException {
		Users users = userService.getUsers(usersId);

		users.setEmailId(usersDetails.getEmailId());
		users.setLastName(usersDetails.getLastName());
		users.setFirstName(usersDetails.getFirstName());
		users.setUserName(usersDetails.getUserName());
		users.setPhoneNumber(usersDetails.getPhoneNumber());
		users.setPassword(usersDetails.getPassword());
		final Users updatedUsers = userService.saveUsers(users);
		return ResponseEntity.ok(updatedUsers);
	}

//http://localhost:8080/api/v1/deleteUsers/1
	@DeleteMapping(value = "/deleteUsers/{UserId}")
	public ResponseEntity<Object> deleteUsers(@PathVariable("UserId") int empId) {

	userService.deleteUsers(empId);
		return new ResponseEntity<>("Employee deleted successsfully", HttpStatus.OK);
	}
	

}