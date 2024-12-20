package com.pointOfSale.suvaraj.project1.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tbl_Sale")
@Data
public class Sale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	private LocalDateTime date;
	private double totalAmount;
	private String paymentMethod;
	private String status;
	
	@OneToMany(mappedBy = "sale",cascade = CascadeType.ALL)
	private List<SaleItem> saleItems;
	
	@ManyToOne
	@JoinColumn(name="customer_Id")
	private Customer customer;
	
	@OneToMany(mappedBy = "sale",cascade = CascadeType.ALL)
	private List<Payment> payment;
	
	
	@PrePersist
	public void prePersists() {
		LocalDateTime currentDate =LocalDateTime.now();
		this.date=currentDate;
	}
	
	private Sale(double totalAmount)
	{
		this.totalAmount=totalAmount;
	}
	
	
	

}
