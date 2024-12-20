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

import com.pointOfSale.suvaraj.project1.entity.Sale;
import com.pointOfSale.suvaraj.project1.services.SaleService;

@RestController
@RequestMapping("/sale")
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
	@PostMapping
	public Sale createSale(@RequestBody Sale sale) {
		return saleService.addSale(sale);
	}
	
	@GetMapping("/{id}")
	public  Sale saleById(@PathVariable Long id) {
		return saleService.getSale(id);
	}
	
	@GetMapping
	public List<Sale> saleAll(){
		return saleService.getSales();
	}
	@PutMapping("/{id}")
	public Sale editSale(@PathVariable long id,@RequestBody Sale sale) {
		return saleService.updateSale(id, sale);
	}
	@DeleteMapping("/{id}")
	public String removeSale(@PathVariable long id) {
		saleService.deleteSale(id);
		return "Successfully Deleted";
	}
	
     

}

