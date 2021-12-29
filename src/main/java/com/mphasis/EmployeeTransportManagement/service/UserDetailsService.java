package com.mphasis.EmployeeTransportManagement.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.EmployeeTransportManagement.dao.UserRepository;
import com.mphasis.EmployeeTransportManagement.model.Users;



@Service
public class UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public List<Users> fetchUsers() {
		List<Users> empList=userRepository.findAll();
		return empList;
		
	}
	@Transactional
	public Users saveUsers(Users users) {
		return userRepository.save(users);
		
	}
	@Transactional
	public void updateUsers(Users users) {
		userRepository.save(users);	
	
	}
	
	@Transactional
	public void deleteUsers(int empId) {
		//empRepository.delete(emp);	
		System.out.println("service method called");
		userRepository.deleteById(empId);
	
	}
	@Transactional 
	  public Users getUsers(int id) { 
	  Optional<Users> optional= userRepository.findById(id);
	  Users users=optional.get();
	  return users;
	/*@Transactional  
  public void validateUsers(Users users)	{
		
		//return (bean.getUsername().equals("admin") && bean.getPassword().equals("admin@123"));
		boolean result=userRepository.validateUser(Users);
		return result;
	}*/

}
}