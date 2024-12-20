package com.pointOfSale.suvaraj.project1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pointOfSale.suvaraj.project1.entity.SaleItem;
import com.pointOfSale.suvaraj.project1.repository.SaleItemRepository;

@Service
public class SaleitemService implements ISaleitemService{
	
	@Autowired
	private SaleItemRepository repo;
	

	@Override
	public SaleItem addSaleItem(SaleItem saleItem) {
		repo.save(saleItem);
		return saleItem;
	}

	@Override
	public SaleItem getSaleItem(long id) {
		if (repo.findById(id).isEmpty()) {
			throw new RuntimeException("Invalid ID...Entered ID is not found,Please enter valid Id");
		} else {

			return repo.findById(id).get();
		}
	}

	@Override
	public List<SaleItem> getSaleItems() {
		
		return repo.findAll();
	}

	@Override
	public SaleItem updateSaleItem(long id, SaleItem saleItem) {
		if(repo.findById(id).isEmpty()){
			throw new RuntimeException("SaleItem  ID is not found");
		}
		else {
			saleItem.setId(id);
			addSaleItem(saleItem);
		}
		
		return saleItem ;
	}

	@Override
	public String deleteSaleItem(long id) {
		repo.deleteById(id);
		return "SaleItem Deleted Successfully";
	}

}
