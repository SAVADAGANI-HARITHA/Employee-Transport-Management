package com.mphasis.EmployeeTransportManagement.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mphasis.EmployeeTransportManagement.model.Users;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {
    
}