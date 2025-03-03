package com.pointOfSale.suvaraj.project1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pointOfSale.suvaraj.project1.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {

	public Optional<Category> findByName(String name);

}
