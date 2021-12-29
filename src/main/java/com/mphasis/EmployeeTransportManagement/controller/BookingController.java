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
import com.mphasis.EmployeeTransportManagement.model.Booking;
import com.mphasis.EmployeeTransportManagement.service.BookingService;

//@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1")
@RestController
public class BookingController {

	@Autowired
	BookingService bookingService;

//http://localhost:9080/api/v1/getAllBookings
	@GetMapping("/getAllBookingS")
	public List<Booking> getBookings() {
		List<Booking> bookingList = bookingService.fetchBookings();

		return bookingList;

	}

	// http://localhost:9080/api/v1/getBooking/1
	@GetMapping("/getBooking/{bookingId}")
	public ResponseEntity<Booking> getBookingById(@PathVariable("bookingId") int bookingId)
			throws ResourceNotFoundException {
		Booking booking = bookingService.getBooking(bookingId);
		return ResponseEntity.ok().body(booking);
	}

	// http://localhost:9080/api/v1/saveBooking
	@PostMapping("/saveBooking")
	public Booking addBooking(@RequestBody Booking booking) {

		Booking booking1 = bookingService.saveBooking(booking);

		// return new ResponseEntity<>("Employee added successsfully", HttpStatus.OK);
		return booking1 ;
	}

	// http://localhost:9080/api/v1/updateBooking/2
	@PutMapping("/updateBooking/{id}")
	public ResponseEntity<Booking> updateBooking(@PathVariable("id") int bookingId,
			@RequestBody Booking bookingDetails) throws ResourceNotFoundException {
		Booking booking = bookingService.getBooking(bookingId);
		booking.setVehicleId(bookingDetails.getVehicleId());
		booking.setEmpId(bookingDetails.getEmpId());
		booking.setPickupTime(bookingDetails.getPickupTime());
		booking.setDropoffTime(bookingDetails.getDropoffTime());
		
		final Booking updatedBooking = bookingService.saveBooking(booking);
		return ResponseEntity.ok(updatedBooking);
	}

//http://localhost:9080/api/v1/deleteBookinge/1
	@DeleteMapping(value = "/deleteBooking/{bookingId}")
	public ResponseEntity<Object> deleteBooking(@PathVariable("bookingId") int bookingId) {

		bookingService.deleteBooking(bookingId);
		return new ResponseEntity<>("Booking details deleted successsfully", HttpStatus.OK);
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
