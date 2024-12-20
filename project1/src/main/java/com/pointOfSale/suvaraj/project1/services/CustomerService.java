package com.pointOfSale.suvaraj.project1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pointOfSale.suvaraj.project1.entity.Category;
import com.pointOfSale.suvaraj.project1.entity.Customer;
import com.pointOfSale.suvaraj.project1.entity.Sale;
import com.pointOfSale.suvaraj.project1.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService {
	@Autowired
	private CustomerRepository repo;

	@Override
	public Customer addCustomer(Customer customer) {
		/*
		 * for (Sale sale : customer.getSales()) { sale.setCustomer(customer); }
		 */
		return repo.save(customer);
	}

	@Override
	public Customer getCustomer(long id) {
		if (repo.findById(id).isEmpty()) {
			throw new RuntimeException("Invalid ID...Entered ID is not found,Please enter valid Id");
		} else {

			return repo.findById(id).get();
		}
	}

	@Override
	public List<Customer> getCustomers() {

		return repo.findAll();
	}

	@Override
	public Customer updateCustomer(long id, Customer customer) {
		if (repo.findById(id).isEmpty()) {
			throw new RuntimeException("Customer  ID is not found");
		} else {
			customer.setId(id);
			addCustomer(customer);
		}

		return customer;
	}

	@Override
	public String deleteCustomer(long id) {
		repo.deleteById(id);
		return "Customer Deleted Successfully";
	}

	public boolean checkIfCustomerExists(String phone) {
		Optional<Customer> customer = repo.findByPhone(phone);
		return customer.isPresent();
	}

	

}
