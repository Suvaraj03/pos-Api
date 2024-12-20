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

import com.pointOfSale.suvaraj.project1.entity.Inventory;
import com.pointOfSale.suvaraj.project1.services.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@PostMapping
	public Inventory createInventory(@RequestBody Inventory inventory) {
		return inventoryService.addInventory(inventory);
	}
	
	@GetMapping("/{id}")
	public  Inventory inventoryById(@PathVariable Long id) {
		return inventoryService.getInventory(id);
	}
	
	@GetMapping
	public List<Inventory> inventoryAll(){
		return inventoryService.getInventories();
	}
	@PutMapping("/{id}")
	public Inventory editInventory(@PathVariable long id,@RequestBody Inventory inventory) {
		return inventoryService.updateInventory(id, inventory);
	}
	@DeleteMapping("/{id}")
	public String removeInventory(@PathVariable long id) {
		inventoryService.deleteInventory(id);
		return "Successfully Deleted";
	}
	
     

}
