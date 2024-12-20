package com.pointOfSale.suvaraj.project1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_saleItem")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleItem {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private long id;
	@ManyToOne
	@JoinColumn(name="Product_id")
	@JsonIgnore
	private Product product;
	@ManyToOne
	@JoinColumn(name="sale_id")
	@JsonIgnore
	private Sale sale;
	private int quantity;
	private double price;

}
