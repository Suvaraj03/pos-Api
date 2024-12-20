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

import com.pointOfSale.suvaraj.project1.entity.Supplier;
import com.pointOfSale.suvaraj.project1.services.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	@PostMapping
	public Supplier createSale(@RequestBody Supplier supplier) {
		return supplierService.addSupplier(supplier);
	}
	
	@GetMapping("/{id}")
	public  Supplier supplierById(@PathVariable Long id) {
		return supplierService.getSupplier(id);
	}
	
	@GetMapping
	public List<Supplier> supplierAll(){
		return supplierService.getSuppliers();
	}
	@PutMapping("/{id}")
	public Supplier editSale(@PathVariable long id,@RequestBody Supplier supplier) {
		return supplierService.updateSupplier(id, supplier);
	}
	@DeleteMapping("/{id}")
	public String removeSale(@PathVariable long id) {
		supplierService.deleteSupplier(id);
		return "Successfully Deleted";
	}
	
     

}

