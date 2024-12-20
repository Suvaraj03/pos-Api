package com.pointOfSale.suvaraj.project1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pointOfSale.suvaraj.project1.entity.Payment;
import com.pointOfSale.suvaraj.project1.entity.Sale;
import com.pointOfSale.suvaraj.project1.entity.SaleItem;
import com.pointOfSale.suvaraj.project1.repository.SaleRepository;

@Service
public class SaleService implements ISaleService {

	@Autowired
	private SaleRepository repo;

	@Override
	public Sale addSale(Sale sale) {
		for (SaleItem saleitem : sale.getSaleItems()) {
			saleitem.setSale(sale);
			for (Payment item : sale.getPayment()) {
				item.setSale(sale);
			}
		}

		return repo.save(sale);
	}

	@Override
	public Sale getSale(long id) {
		if (repo.findById(id).isEmpty()) {
			throw new RuntimeException("Invalid ID...Entered ID is not found,Please enter valid Id");
		} else {

			return repo.findById(id).get();
		}
	}

	@Override
	public List<Sale> getSales() {
		
		return repo.findAll();
	}

	@Override
	public Sale updateSale(long id, Sale sale) {
		if(repo.findById(id).isEmpty()){
			throw new RuntimeException("Sale  ID is not found");
		}
		else {
			sale.setId(id);
			addSale(sale);
		}
		
		return sale;
	}

	@Override
	public String deleteSale(long id) {
		repo.deleteById(id);
		return "Sale logs  Deleted  Successfully";
	}

}
