package com.pointOfSale.suvaraj.project1.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String phone;
	private String address;
	private int loyalityPoints;
	
	/*
	 * @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL) private
	 * List<Sale> sales;
	 */
	
	private Customer(String phone)
	{
		this.phone=phone;
	}
	
}
