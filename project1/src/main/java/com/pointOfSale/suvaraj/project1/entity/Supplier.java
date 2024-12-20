package com.pointOfSale.suvaraj.project1.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_supplier")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String contactPerson;
	private String email;
	private String phone;
	private String address;
	
	@OneToMany(mappedBy = "supplier",cascade = CascadeType.ALL)
	private List<Product> product;
	
	
	
}

