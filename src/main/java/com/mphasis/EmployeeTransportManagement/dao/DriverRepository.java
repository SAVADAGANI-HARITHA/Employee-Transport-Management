package com.mphasis.EmployeeTransportManagement.dao;



import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mphasis.EmployeeTransportManagement.model.Driver;


@Repository
public interface DriverRepository extends JpaRepository<Driver ,Integer>  {

	//@Query("SELECT e FROM Employee e WHERE e.status =?1") /*JPQL*/
	//Collection<Employee> findAllActiveEmployees();
	
}
