package com.pointOfSale.suvaraj.project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.pointOfSale.suvaraj.project1.entity.Payment;
import com.pointOfSale.suvaraj.project1.services.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping
	public Payment createPayment(@RequestBody Payment payment) {
		return paymentService.addPayment(payment);
	}
	
	@GetMapping("/{id}")
	public  Payment paymentById(@PathVariable Long id) {
		return paymentService.getPayment(id);
	}
	
	@GetMapping
	public List<Payment> paymentAll(){
		return paymentService.getPayments();
	}
	@PutMapping("/{id}")
	public Payment editPayment(@PathVariable long id,@RequestBody Payment payment) {
		return paymentService.updatePayment(id, payment);
	}
	@DeleteMapping("/{id}")
	public String removePayment(@PathVariable long id) {
		paymentService.deletePayment(id);
		return "Successfully Deleted";
	}
	
     

}
