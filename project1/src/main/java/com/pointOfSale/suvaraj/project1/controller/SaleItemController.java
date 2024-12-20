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

import com.pointOfSale.suvaraj.project1.entity.SaleItem;
import com.pointOfSale.suvaraj.project1.services.SaleitemService;

@RestController
@RequestMapping("/saleitem")
public class SaleItemController {
	
	@Autowired
	private SaleitemService saleitemService;
	
	@PostMapping
	public SaleItem createSale(@RequestBody SaleItem saleitem) {
		return saleitemService.addSaleItem(saleitem);
	}
	
	@GetMapping("/{id}")
	public  SaleItem saleById(@PathVariable Long id) {
		return saleitemService.getSaleItem(id);
	}
	
	@GetMapping
	public List<SaleItem> saleAll(){
		return saleitemService.getSaleItems();
	}
	@PutMapping("/{id}")
	public SaleItem editSale(@PathVariable long id,@RequestBody SaleItem sale) {
		return saleitemService.updateSaleItem(id, sale);
	}
	@DeleteMapping("/{id}")
	public String removeSale(@PathVariable long id) {
		saleitemService.deleteSaleItem(id);
		return "Successfully Deleted";
	}
	
     

}

