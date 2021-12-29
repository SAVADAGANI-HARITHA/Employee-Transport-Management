package com.mphasis.EmployeeTransportManagement.dao;
//import java.util.Collection;


import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.mphasis.EmployeeTransportManagement.model.TimeSlot;
@Repository
public interface TimeslotRepository extends JpaRepository <TimeSlot ,Integer> {

}