package com.pointOfSale.suvaraj.project1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.pointOfSale.suvaraj.project1.entity.Category;
import com.pointOfSale.suvaraj.project1.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping
	public Category createCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}

	@GetMapping("/{id}")
	public Category categoryById(@PathVariable Long id) {
		return categoryService.getCategory(id);
	}

	@GetMapping
	public List<Category> categoryAll() {
		return categoryService.getCategories();
	}

	@PutMapping("/{id}")
	public Category editCategory(@PathVariable long id, @RequestBody Category category) {
		return categoryService.updateCategory(id, category);
	}

	@DeleteMapping("/{id}")
	public String removeCategory(@PathVariable long id) {
		categoryService.deleteCategory(id);
		return "Successfully Deleted";
	}

	@GetMapping("byname/{name}")
	public ResponseEntity<Object> checkCategory(@PathVariable("name") String name) {

		boolean categoryExists = categoryService.checkIfCategoryExists(name);

		if (categoryExists) {
			return ResponseEntity.ok("Category found: " + categoryService.getCategoryByName(name));
		} else {
			return ResponseEntity.status(200).body("Category not found with name: " + name);

		}
	}

}
