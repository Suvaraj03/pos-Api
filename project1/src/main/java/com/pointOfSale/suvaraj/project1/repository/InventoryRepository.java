package com.pointOfSale.suvaraj.project1.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pointOfSale.suvaraj.project1.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	
	
	 	@Query("SELECT i FROM Inventory i WHERE i.product.id = :productId")
	    Optional<Inventory> findByProductId(Long productId);
		
}
