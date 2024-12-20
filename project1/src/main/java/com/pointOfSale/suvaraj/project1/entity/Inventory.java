package com.pointOfSale.suvaraj.project1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_inventory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int quantityInStock;
	private int reorderLevel;
	
	@OneToOne
	@JoinColumn(name="product_Id")
	@JsonIgnore
	private Product product;

	public Inventory(int qty)
	{
		this.quantityInStock=qty;
	}
	

}
