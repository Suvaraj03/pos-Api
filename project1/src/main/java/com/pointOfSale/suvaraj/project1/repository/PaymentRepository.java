package com.pointOfSale.suvaraj.project1.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pointOfSale.suvaraj.project1.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	/*
	 * public Payment findByDate(LocalDateTime date); public Payment
	 * findByMethod(String paymentMethod);
	 */

}
