package com.pointOfSale.suvaraj.project1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pointOfSale.suvaraj.project1.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	public Optional<Customer> findByPhone(String phone);

}
