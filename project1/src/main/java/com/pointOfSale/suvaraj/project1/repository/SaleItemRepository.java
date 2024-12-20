package com.pointOfSale.suvaraj.project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pointOfSale.suvaraj.project1.entity.SaleItem;

public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {

}
