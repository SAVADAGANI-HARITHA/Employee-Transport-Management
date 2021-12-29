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

import com.mphasis.EmployeeTransportManagement.exception.ResourceNotFoundException;
import com.mphasis.EmployeeTransportManagement.model.Vehicle;
import com.mphasis.EmployeeTransportManagement.service.VehicleService;


//@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1")
@RestController
public class VehicleController {

	@Autowired
	VehicleService vehicleService;

//http://localhost:9080/api/v1/getAllVehicles
	@GetMapping("/getAllVehicles")
	public List<Vehicle> getVehicles() {
		List<Vehicle> vehicleList = vehicleService.fetchVehicles();

		return vehicleList;

	}

	// http://localhost:9080/api/v1/getVehicle/1
	@GetMapping("/getVehicle/{vehicleId}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable("vehicleId") int vehicleId)
			throws ResourceNotFoundException {
		Vehicle vehicle = vehicleService.getVehicle(vehicleId);
		return ResponseEntity.ok().body(vehicle);
	}

	// http://localhost:9080/api/v1/saveVehicle
	@PostMapping("/saveVehicle")
	public Vehicle addVehicle(@RequestBody Vehicle vehicle) {

		Vehicle vehicle1 = vehicleService.saveVehicle(vehicle);

		// return new ResponseEntity<>("Employee added successsfully", HttpStatus.OK);
		return vehicle1 ;
	}

	// http://localhost:9080/api/v1/updateVehicle/2
	@PutMapping("/updateVehicle/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") int vehicleId,
			@RequestBody Vehicle vehicleDetails) throws ResourceNotFoundException {
		Vehicle vehicle = vehicleService.getVehicle(vehicleId);
		vehicle.setVehicleName(vehicleDetails.getVehicleName());
		vehicle.setRouteName(vehicleDetails.getRouteName());
		vehicle.setDriverId(vehicleDetails.getDriverId());
		
		final Vehicle updatedVehicle = vehicleService.saveVehicle(vehicle);
		return ResponseEntity.ok(updatedVehicle);
	}

//http://localhost:8080/api/v1/deleteDrive/1
	@DeleteMapping(value = "/deleteVehicle/{vehicleId}")
	public ResponseEntity<Object> deleteVehicle(@PathVariable("vehicleId") int vehicleId) {

		vehicleService.deleteVehicle(vehicleId);
		return new ResponseEntity<>("Vehicle details deleted successsfully", HttpStatus.OK);
	}
	/*
	 * @DeleteMapping("/deleteEmployee/{id}") public Map<String, Boolean>
	 * deleteEmployee(@PathVariable("id") int employeeId) throws
	 * ResourceNotFoundException { // Employee employee =
	 * empService.getEmployee(employeeId);
	 * 
	 * System.out.println("delete method called");
	 * empService.deleteEmployee(employeeId); Map<String, Boolean> response = new
	 * HashMap<>(); response.put("deleted", Boolean.TRUE); return response; }
	 */

}
