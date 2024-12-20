package com.pointOfSale.suvaraj.project1.services;

import java.util.List;

import com.pointOfSale.suvaraj.project1.entity.Category;

public interface ICategoryService {
	public Category addCategory(Category category);
	//public Category addCountries(List<E>);
	public Category getCategory(long id);
	public List<Category> getCategories();
	public Category updateCategory(long id,Category category);
	public String  deleteCategory(long id);
}
