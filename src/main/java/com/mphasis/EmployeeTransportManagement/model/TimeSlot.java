package com.mphasis.EmployeeTransportManagement.model;
import java.sql.Time;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;


import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="timeslot")
public class TimeSlot {
	@Id
	@Column(name="timeslot_id")
	private int id;
	@Temporal(TemporalType.TIMESTAMP) 
	@Column(name="timeslot_time")
	
	private Date timeslotTime ;
	
	public TimeSlot( int id,Date timeslotTime) {
        super();
        this.id=id;
        this.timeslotTime = timeslotTime;
        
    }
	
	public TimeSlot() {
		// TODO Auto-generated constructor stub
	}

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getTimeslotTime() {
		return timeslotTime;
	}
	public void setTimeslotTime(Date timeslotTime) {
		this.timeslotTime = timeslotTime;
	}
}