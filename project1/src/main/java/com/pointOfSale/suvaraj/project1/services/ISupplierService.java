package com.pointOfSale.suvaraj.project1.services;

import java.util.List;

import com.pointOfSale.suvaraj.project1.entity.Supplier;

public interface ISupplierService {
	public Supplier addSupplier(Supplier supplier);
	//public Supplier addCountries(List<E>);
	public Supplier getSupplier(long id);
	public List<Supplier> getSuppliers();
	public Supplier updateSupplier(long id,Supplier supplier);
	public String  deleteSupplier(long id);

}
