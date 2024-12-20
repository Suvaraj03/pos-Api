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

import com.pointOfSale.suvaraj.project1.entity.Product;
import com.pointOfSale.suvaraj.project1.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	@GetMapping("/{id}")
	public  Product productById(@PathVariable Long id) {
		return productService.getProduct(id);
	}
	
	@GetMapping
	public List<Product> productAll(){
		return productService.getProducts();
	}
	@PutMapping("/{id}")
	public Product editProduct(@PathVariable long id,@RequestBody Product product) {
		return productService.updateProduct(id, product);
	}
	@DeleteMapping("/{id}")
	public String removeProduct(@PathVariable long id) {
		productService.deleteProduct(id);
		return "Successfully Deleted";
	}
	
     

}

