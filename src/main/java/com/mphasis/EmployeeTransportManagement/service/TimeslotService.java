package com.mphasis.EmployeeTransportManagement.service;
import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.EmployeeTransportManagement.dao.TimeslotRepository;
import com.mphasis.EmployeeTransportManagement.model.TimeSlot;
@Service
public class TimeslotService {
	@Autowired
	TimeslotRepository timeslotRepository;
	
	@Transactional
	public List<TimeSlot> fetchTimeSlots() {
		List<TimeSlot> timeslotList=timeslotRepository.findAll();
		return timeslotList;
		
	}
	@Transactional
	public TimeSlot saveTimeSlot(TimeSlot tslot) {
		
		return timeslotRepository.save(tslot);
		
	}
	@Transactional
	public void updateTimeSlot(TimeSlot tslot1) {
		timeslotRepository.save(tslot1);	
	
	}
	
	@Transactional
	public void deleteTimeSlot(int timeslotId) {
		//empRepository.delete(emp);	
		System.out.println("service method called");
		timeslotRepository.deleteById(timeslotId);
	
	}
	public TimeSlot getTimeslot(int timeslotId) {
		 Optional<TimeSlot> optional= timeslotRepository.findById(timeslotId);
		  TimeSlot tslot=optional.get();
		  return tslot;
		  
	}
	
}