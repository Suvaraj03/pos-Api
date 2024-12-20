package com.pointOfSale.suvaraj.project1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.pointOfSale.suvaraj.project1.entity.Category;
import com.pointOfSale.suvaraj.project1.entity.Product;
import com.pointOfSale.suvaraj.project1.repository.CategoryRepository;

@Service

public class CategoryService implements ICategoryService {
	@Autowired
	private CategoryRepository repo;

	

	@Override
	public Category addCategory(Category category) {
		/*
		 * for (Product product : category.getProducts()) {
		 * product.setCategory(category); }
		 */
		
		return repo.save(category);
	}

	@Override
	public Category getCategory(long id) {
		if (repo.findById(id).isEmpty()) {
			throw new RuntimeException("Invalid ID...Entered ID is not found,Please enter valid Id");
		} else {

			return repo.findById(id).get();
		}

	}
	
	

	@Override
	public List<Category> getCategories() {

		return repo.findAll();
	}

	@Override
	public Category updateCategory(long id, Category category) {

		if (repo.findById(id).isEmpty()) {
			throw new RuntimeException("Category Id not found");
		} else {
			category.setId(id);
			return addCategory(category);
		}
	}

	@Override
	public String deleteCategory(long id) {
		repo.deleteById(id);
		return "Deleted Successfully" + getCategory(id);
	}

	public boolean checkIfCategoryExists(String name) {
		Optional<Category> category = repo.findByName(name);
		return category.isPresent();
	}
	public Optional<Category> getCategoryByName(String name) {
		return repo.findByName(name);
		
	}

}
