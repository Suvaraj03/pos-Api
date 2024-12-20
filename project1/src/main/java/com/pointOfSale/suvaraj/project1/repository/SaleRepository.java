package com.pointOfSale.suvaraj.project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pointOfSale.suvaraj.project1.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}
