package com.mphasis.EmployeeTransportManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "UserRegistration", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})
})
public class Users {
	@Id
	@GeneratedValue
	@Column(name="empid",nullable=false)
	private int id;
	@Column(name="firstname",nullable=false,length=60)
	private String firstName;
	@Column(name="lastname",nullable=false,length=60)
	private String lastName;
	@Column(name="username",nullable=false,length=60)
	private String userName;
	@Column(name="email",nullable=false,length=60)
	private String emailId;
	@Column(name="contact",nullable=false)
	private int phoneNumber ;
	@Column(name="password",nullable=false,length=60)
	private String password;
	
	public Users(String firstName, String lastName, String userName,String emailId,int phoneNumber,String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
	public Users() {
		// TODO Auto-generated constructor stub
	}

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

