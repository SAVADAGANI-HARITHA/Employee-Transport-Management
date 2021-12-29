package com.mphasis.EmployeeTransportManagement.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.EmployeeTransportManagement.dao.BookingRepository;
import com.mphasis.EmployeeTransportManagement.model.Booking;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	@Transactional
	public List<Booking> fetchBookings() {
		List<Booking> bookingList=bookingRepository.findAll();
		return bookingList;
		
	}
	@Transactional
	public Booking saveBooking(Booking booking) {
		
		return bookingRepository.save(booking);
		
	}
	@Transactional
	public void updateBooking(Booking booking) {
		bookingRepository.save(booking);	
	
	}
	
	@Transactional
	public void deleteBooking(int bookingId) {
		//empRepository.delete(emp);	
		System.out.println("service method called");
		bookingRepository.deleteById(bookingId);
	
	}
	@Transactional 
	  public Booking getBooking(int id) { 
	  Optional<Booking> optional= bookingRepository.findById(id);
	  Booking booking=optional.get();
	  return booking;
	  

}
}
