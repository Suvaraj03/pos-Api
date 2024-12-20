package com.pointOfSale.suvaraj.project1.services;

import java.util.List;

import com.pointOfSale.suvaraj.project1.entity.Sale;

public interface ISaleService {
	public Sale addSale(Sale sale);
	//public Sale addCountries(List<E>);
	public Sale getSale(long id);
	public List<Sale> getSales();
	public Sale updateSale(long id,Sale sale);
	public String  deleteSale(long id);

}
