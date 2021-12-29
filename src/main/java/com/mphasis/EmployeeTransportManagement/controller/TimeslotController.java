package com.mphasis.EmployeeTransportManagement.controller;
import java.util.List;

//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.EmployeeTransportManagement.model.TimeSlot;
import com.mphasis.EmployeeTransportManagement.service.TimeslotService;

import com.mphasis.EmployeeTransportManagement.exception.ResourceNotFoundException;
//import com.mphasis.EmployeeTransportManagement.model.TimeSlot;
//import com.mphasis.EmployeeTransportManagement.dao.;

//@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1")
@RestController
public class TimeslotController {
	@Autowired
	TimeslotService timeslotService;

//http://localhost:9080/api/v1/getAllTimeSlots
	@GetMapping("/getAllTimeSlots")
	public List<TimeSlot> getTimeSlots() {
		List<TimeSlot> timeslotList = timeslotService.fetchTimeSlots();
			return timeslotList;

	}

	// http://localhost:9080/api/v1/saveTimeSlot
	@PostMapping("/saveTimeSlot")
	public TimeSlot addTimeSlot(@RequestBody TimeSlot tslot) {

		TimeSlot timeslot = timeslotService.saveTimeSlot(tslot);

		// return new ResponseEntity<>("Employee added successsfully", HttpStatus.OK);
		return timeslot;
	}

	// http://localhost:8080/api/v1/updateTimeSlot/2
	@PutMapping("/updateTimeSlot/{id}")
	public ResponseEntity<TimeSlot> updateTimeSlot(@PathVariable("id") int timeslotId,
			@RequestBody TimeSlot timeslotDetails) throws ResourceNotFoundException {
		TimeSlot timeslot = timeslotService.getTimeslot(timeslotId);

		timeslot.setTimeslotTime(timeslotDetails.getTimeslotTime());
	   final TimeSlot updatedTimeSlot = timeslotService.saveTimeSlot(timeslot);
		return ResponseEntity.ok(updatedTimeSlot);
	}

//http://localhost:8080/api/v1/deleteEmployee/1
	@DeleteMapping(value = "/deleteTimeSlot/{timeslotId}")
	public ResponseEntity<Object> deleteTimeSlot(@PathVariable("timeslotId") int tslotId) {

		timeslotService.deleteTimeSlot(tslotId);
		return new ResponseEntity<>("TimeSlot deleted successsfully", HttpStatus.OK);
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