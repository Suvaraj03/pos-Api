package com.pointOfSale.suvaraj.project1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="tbl_product")
@Data
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	private double price;
	private int quantity;
	//private String barcode;
	
	@ManyToOne
	@JoinColumn(name="category_Id",nullable = true)
	private Category category;
	
	@OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
	private Inventory inventory;
	
	@ManyToOne
	@JoinColumn(name="supplier_id",nullable = true)
	@JsonIgnore
	private Supplier supplier;
	
	public Product(String name)
	{
		this.name=name;
	}

	public Product(long id, String name, String description, double price, int quantity, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}
	
	
		
	
}
