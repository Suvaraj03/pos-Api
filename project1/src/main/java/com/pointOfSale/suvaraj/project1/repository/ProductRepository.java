package com.pointOfSale.suvaraj.project1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pointOfSale.suvaraj.project1.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	public Optional<Product> findByName(String name);

}
