package com.mphasis.EmployeeTransportManagement.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.mapping.Set;

@Entity
@Table(name="driver")
public class Driver {
	@Id
	@GeneratedValue
	@Column(name="driver_id")
	private int id;
	@Column(name="driver_name")
	
	private String driverName;
	@Column(name="vehicle_id")
	private int vehicleId;
	@Column(name="timeslot_id")
	private int timeslotId;
	public Driver(String driverName, int vehicleId,int timeslotId) {
        super();
        this.driverName = driverName;
        this.vehicleId = vehicleId;
        this.timeslotId = timeslotId;
    }
	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public int getTimeslotId() {
		return timeslotId;
	}
	public void setTimeslotId(int timeslotId) {
		this.timeslotId = timeslotId;
	}
	/*@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "driver",
        joinColumns = @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicle_id"),
        inverseJoinColumns = @JoinColumn(name = "timeslot_id", referencedColumnName = "timeslot_id"))
	private Set vehicle;*/

}
