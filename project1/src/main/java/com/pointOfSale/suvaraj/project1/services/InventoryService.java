package com.pointOfSale.suvaraj.project1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pointOfSale.suvaraj.project1.entity.Inventory;
import com.pointOfSale.suvaraj.project1.repository.InventoryRepository;

@Service
public class InventoryService implements IInventoryService{

	@Autowired
	private InventoryRepository repo;
	
	
	@Override
	public Inventory addInventory(Inventory inventory) {
		
		return repo.save(inventory);
	}

	@Override
	public Inventory getInventory(long id) {
	
		if (repo.findById(id).isEmpty()) {
			throw new RuntimeException("Invalid ID...Entered ID is not found,Please enter valid Id");
		} else {

			return repo.findById(id).get();
		}
	}

	@Override
	public List<Inventory> getInventories() {
		
		return repo.findAll();
	}

	@Override
	public Inventory updateInventory(long id, Inventory inventory) {
		if(repo.findById(id).isEmpty()){
			throw new RuntimeException("Inventory  ID is not found");
		}
		else {
			inventory.setId(id);
			addInventory(inventory);
		}
		
		return inventory ;
	}

	@Override
	public String deleteInventory(long id) {
		repo.deleteById(id);
		return "Inventory Deleted Succesfully";
	}
	
	public Optional<Inventory> getInventoryByProduct(Long productId)
	{
		
		return repo.findByProductId(productId);
	}

}
