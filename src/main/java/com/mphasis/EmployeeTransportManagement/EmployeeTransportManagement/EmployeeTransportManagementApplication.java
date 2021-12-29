package com.mphasis.EmployeeTransportManagement.EmployeeTransportManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.*"})
@EnableJpaRepositories(basePackages = {"com.mphasis.EmployeeTransportManagement.dao"})
@EntityScan("com.mphasis.EmployeeTransportManagement.model")
public class EmployeeTransportManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeTransportManagementApplication.class, args);
	}

}
