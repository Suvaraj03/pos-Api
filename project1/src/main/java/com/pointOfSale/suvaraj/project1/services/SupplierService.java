package com.pointOfSale.suvaraj.project1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pointOfSale.suvaraj.project1.entity.Product;
import com.pointOfSale.suvaraj.project1.entity.Supplier;
import com.pointOfSale.suvaraj.project1.repository.SupplierRepository;

@Service
public class SupplierService implements ISupplierService {
	
	@Autowired
	private SupplierRepository   repo;

	@Override
	public Supplier addSupplier(Supplier supplier) {
		for(Product pro:supplier.getProduct()) {
			pro.setSupplier(supplier);
		}
		return repo.save(supplier);
	}

	@Override
	public Supplier getSupplier(long id) {
		if (repo.findById(id).isEmpty()) {
			throw new RuntimeException("Invalid ID...Entered ID is not found,Please enter valid Id");
		} else {

			return repo.findById(id).get();
		}
	}

	@Override
	public List<Supplier> getSuppliers() {
	
		return repo.findAll();
	}

	@Override
	public Supplier updateSupplier(long id, Supplier supplier) {
		if(repo.findById(id).isEmpty()){
			throw new RuntimeException("Payment  ID is not found");
		}
		else {
			supplier.setId(id);
			addSupplier(supplier);
		}
		return supplier;
	}

	@Override
	public String deleteSupplier(long id) {
		repo.deleteById(id);
		return "Supplier Deleted Successfully";
	}

}
