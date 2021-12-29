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
import com.mphasis.EmployeeTransportManagement.model.Driver;
import com.mphasis.EmployeeTransportManagement.service.DriverService;

//@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1")
@RestController
public class DriverController {

	@Autowired
	DriverService driverService;

//http://localhost:9080/api/v1/getAllDrivers
	@GetMapping("/getAllDrivers")
	public List<Driver> getDrivers() {
		List<Driver> driverList = driverService.fetchDrivers();

		return driverList;

	}

	// http://localhost:9080/api/v1/getDriver/1
	@GetMapping("/getDriver/{driverId}")
	public ResponseEntity<Driver> getDriverById(@PathVariable("driverId") int driverId)
			throws ResourceNotFoundException {
		Driver driver = driverService.getDriver(driverId);
		return ResponseEntity.ok().body(driver);
	}

	// http://localhost:9080/api/v1/saveDriver
	@PostMapping("/saveDriver")
	public Driver addDriver(@RequestBody Driver driver) {

		Driver driver1 = driverService.saveDriver(driver);

		// return new ResponseEntity<>("Employee added successsfully", HttpStatus.OK);
		return driver1;
	}

	// http://localhost:9080/api/v1/updateDriver/2
	@PutMapping("/updateDriver/{id}")
	public ResponseEntity<Driver> updateDriver(@PathVariable("id") int driverId,
			@RequestBody Driver driverDetails) throws ResourceNotFoundException {
		Driver driver = driverService.getDriver(driverId);
		driver.setDriverName(driverDetails.getDriverName());
		driver.setVehicleId(driverDetails.getVehicleId());
		driver.setTimeslotId(driverDetails.getTimeslotId());
		
		final Driver updatedDriver = driverService.saveDriver(driver);
		return ResponseEntity.ok(updatedDriver);
	}

//http://localhost:8080/api/v1/deleteDrive/1
	@DeleteMapping(value = "/deleteDriver/{driverId}")
	public ResponseEntity<Object> deleteDriver(@PathVariable("driverId") int driverId) {

		driverService.deleteDriver(driverId);
		return new ResponseEntity<>("Driver details deleted successsfully", HttpStatus.OK);
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
