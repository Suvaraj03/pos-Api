package com.pointOfSale.suvaraj.project1.services;

import java.util.List;

import com.pointOfSale.suvaraj.project1.entity.Product;

public interface IProductService {
	public Product addProduct(Product product);
	//public Product addCountries(List<E>);
	public Product getProduct(long id);
	public List<Product> getProducts();
	public Product updateProduct(long id,Product product);
	public String  deleteProduct(long id);

}
