package com.mphasis.EmployeeTransportManagement.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mphasis.EmployeeTransportManagement.model.User;



public interface LoginRepository extends JpaRepository<User, String>{
	@Query("SELECT u FROM User u WHERE u.userName =?1 and u.password=?2")
			public User validateUser(String userName,String password);
	
	
}