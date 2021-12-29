package com.mphasis.EmployeeTransportManagement.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.mapping.Set;

@Entity
@Table(name="booking")
public class Booking {
	@Id
	@GeneratedValue
	@Column(name="booking_id")
	private int id;
	@Column(name="vehicle_id")
	
	private int vehicleId;
	@Column(name="empid")
	private int empId;
	@Column(name="pickup_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date pickupTime;
	@Column(name="dropoff_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dropoffTime;
	public Booking(int vehicleId, int empId,Date pickupTime,Date dropoffTime) {
        super();
        this.vehicleId = vehicleId;
        this.empId = empId;
        this.pickupTime = pickupTime;
        this.dropoffTime=dropoffTime;
    }
	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Date getPickupTime() {
		return pickupTime;
	}
	public void setPickupTime(Date pickupTime) {
		this.pickupTime= pickupTime;
	}
	public Date getDropoffTime() {
		return dropoffTime;
	}
	public void setDropoffTime(Date dropoffTime) {
		this.dropoffTime= dropoffTime;
	}

}
