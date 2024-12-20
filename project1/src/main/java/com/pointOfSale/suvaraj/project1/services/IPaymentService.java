package com.pointOfSale.suvaraj.project1.services;

import java.util.List;

import com.pointOfSale.suvaraj.project1.entity.Payment;

public interface IPaymentService {
	public Payment addPayment(Payment payment);
	//public Payment addCountries(List<E>);
	public Payment getPayment(long id);
	public List<Payment> getPayments();
	public Payment updatePayment(long id,Payment payment);
	public String  deletePayment(long id);

}
