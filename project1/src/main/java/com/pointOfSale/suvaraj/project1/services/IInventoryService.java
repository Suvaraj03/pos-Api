package com.pointOfSale.suvaraj.project1.services;

import java.util.List;

import com.pointOfSale.suvaraj.project1.entity.Inventory;

public interface IInventoryService {
	public Inventory addInventory(Inventory inventory);
	//public Inventory addCountries(List<E>);
	public Inventory getInventory(long id);
	public List<Inventory> getInventories();
	public Inventory updateInventory(long id,Inventory inventory);
	public String  deleteInventory(long id);

}
