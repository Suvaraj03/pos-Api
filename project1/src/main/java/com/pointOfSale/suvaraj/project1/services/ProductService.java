package com.pointOfSale.suvaraj.project1.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pointOfSale.suvaraj.project1.entity.Category;
import com.pointOfSale.suvaraj.project1.entity.Inventory;
import com.pointOfSale.suvaraj.project1.entity.Product;
import com.pointOfSale.suvaraj.project1.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository repo;

	@Autowired
	private CategoryService catService;

	@Autowired
	private InventoryService inventoryService;

	@Override
	public Product addProduct(Product product) {

		Product exProduct = repo.findByName(product.getName()).orElse(null);

		if (exProduct != null) {
			Inventory exInventory = exProduct.getInventory();
			exInventory
					.setQuantityInStock(exInventory.getQuantityInStock() + product.getInventory().getQuantityInStock());
			inventoryService.addInventory(exInventory);
			return exProduct;
		}

		Category cat = catService
				.getCategoryByName(product.getCategory().getName()).orElseGet(() -> {
			    return catService.addCategory(product.getCategory());
		});

		product.setCategory(cat);
		Product savedProduct = repo.save(product);
		Inventory inventory = product.getInventory();
		inventory.setProduct(savedProduct);

		inventoryService.addInventory(inventory);

		inventoryService.getInventoryByProduct(savedProduct.getId()).get().getProduct().getName();
		return savedProduct;
		/*
		 * for(Inventory invent:product.getInventory()) { invent.setProduct(product);
		 * for(SaleItem saleItem:product.getSaleItem()) { saleItem.setProduct(product);
		 * } } return repo.save(product);
		 */
	}

	@Override
	public Product getProduct(long id) {
		if (repo.findById(id).isEmpty()) {
			throw new RuntimeException("Invalid ID...Entered ID is not found,Please enter valid Id");
		} else {

			return repo.findById(id).get();
		}
	}

	@Override
	public List<Product> getProducts() {

		return repo.findAll();
	}

	@Override
	public Product updateProduct(long id, Product product) {
		if (repo.findById(id).isEmpty()) {
			throw new RuntimeException("Product  ID is not found");
		} else {
			product.setId(id);
			addProduct(product);
		}
		return product;
	}

	@Override
	public String deleteProduct(long id) {
		repo.deleteById(id);
		return "Deleted Product Successfully";
	}

	public Optional<Product> getByName(String name) {
		return repo.findByName(name);
	}

}
