package com.pointOfSale.suvaraj.project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.pointOfSale.suvaraj.project1.entity.Customer;
import com.pointOfSale.suvaraj.project1.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}

	@GetMapping("/{id}")
	public Customer customerById(@PathVariable Long id) {
		return customerService.getCustomer(id);
	}

	@GetMapping
	public List<Customer> customerAll() {
		return customerService.getCustomers();
	}

	@PutMapping("/{id}")
	public Customer editCustomer(@PathVariable long id, @RequestBody Customer customer) {
		return customerService.updateCustomer(id, customer);
	}
	
	@DeleteMapping("/{id}")
	public String removeCustomer(@PathVariable long id) {
		customerService.deleteCustomer(id);
		return "Successfully Deleted";
	}

	@GetMapping("byphone/{phone}")
	public ResponseEntity<String> checkCustomer(@PathVariable("phone") String phone) {
		boolean customerExists = customerService.checkIfCustomerExists(phone);

		if (customerExists) {
			
			
			
			return ResponseEntity.ok("Customer found: " + phone);
		} else {
			return ResponseEntity.status(404).body("Customer not found with name of: " + phone);

		}
	}

}
