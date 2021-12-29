package com.mphasis.EmployeeTransportManagement.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.EmployeeTransportManagement.dao.DriverRepository;
import com.mphasis.EmployeeTransportManagement.model.Driver;

@Service
public class DriverService {

	@Autowired
	DriverRepository driverRepository;
	
	@Transactional
	public List<Driver> fetchDrivers() {
		List<Driver> driverList=driverRepository.findAll();
		return driverList;
		
	}
	@Transactional
	public Driver saveDriver(Driver driver) {
		
		return driverRepository.save(driver);
		
	}
	@Transactional
	public void updateDriver(Driver driver) {
		driverRepository.save(driver);	
	
	}
	
	@Transactional
	public void deleteDriver(int driverId) {
		//empRepository.delete(emp);	
		System.out.println("service method called");
		driverRepository.deleteById(driverId);
	
	}
	@Transactional 
	  public Driver getDriver(int id) { 
	  Optional<Driver> optional= driverRepository.findById(id);
	  Driver driver=optional.get();
	  return driver;
	  

}
}
