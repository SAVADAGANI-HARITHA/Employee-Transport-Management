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
@Table(name="vehicle")
public class Vehicle {
	@Id
	@GeneratedValue
	@Column(name="vehicle_id")
	private int id;
	@Column(name="vehicle_name")
	
	private String vehicleName;
	@Column(name="route_name")
	private String routeName;
	@Column(name="driver_id")
	private int driverId;
	public Vehicle(String vehicleName, String routeName,int driverId) {
        super();
        this.vehicleName = vehicleName;
        this.routeName = routeName;
        this.driverId = driverId;
    }
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	

}
