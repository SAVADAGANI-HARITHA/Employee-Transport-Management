package com.mphasis.EmployeeTransportManagement.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.EmployeeTransportManagement.dao.VehicleRepository;
import com.mphasis.EmployeeTransportManagement.model.Vehicle;

@Service
public class VehicleService {

	@Autowired
	VehicleRepository vehicleRepository;
	
	@Transactional
	public List<Vehicle> fetchVehicles() {
		List<Vehicle> vehicleList=vehicleRepository.findAll();
		return vehicleList;
		
	}
	@Transactional
	public Vehicle saveVehicle(Vehicle vehicle) {
		
		return vehicleRepository.save(vehicle);
		
	}
	@Transactional
	public void updateVehicle(Vehicle vehicle) {
		vehicleRepository.save(vehicle);	
	
	}
	
	@Transactional
	public void deleteVehicle(int vehicleId) {
		//empRepository.delete(emp);	
		System.out.println("service method called");
		vehicleRepository.deleteById(vehicleId);
	
	}
	@Transactional 
	  public Vehicle getVehicle(int id) { 
	  Optional<Vehicle> optional= vehicleRepository.findById(id);
	  Vehicle vehicle=optional.get();
	  return vehicle;
	  

}
}
