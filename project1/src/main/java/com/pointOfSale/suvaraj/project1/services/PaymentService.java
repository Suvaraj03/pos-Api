package com.pointOfSale.suvaraj.project1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pointOfSale.suvaraj.project1.entity.Payment;
import com.pointOfSale.suvaraj.project1.repository.PaymentRepository;

@Service
public class PaymentService implements IPaymentService {
	
	@Autowired
	private PaymentRepository repo;

	@Override
	public Payment addPayment(Payment payment) {
		
		return repo.save(payment);
	}

	@Override
	public Payment getPayment(long id) {
		if (repo.findById(id).isEmpty()) {
			throw new RuntimeException("Invalid ID...Entered ID is not found,Please enter valid Id");
		} else {

			return repo.findById(id).get();
		}
	}

	@Override
	public List<Payment> getPayments() {
		
		return repo.findAll();
	}

	@Override
	public Payment updatePayment(long id, Payment payment) {
		if(repo.findById(id).isEmpty()){
			throw new RuntimeException("Payment  ID is not found");
		}
		else {
			payment.setId(id);
			addPayment(payment);
		}
		return payment;
	}

	@Override
	public String deletePayment(long id) {
		repo.deleteById(id);
		return "Payment Deleted Successfully";
	}

}
