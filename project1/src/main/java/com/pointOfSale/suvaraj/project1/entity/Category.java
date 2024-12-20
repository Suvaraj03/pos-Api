package com.pointOfSale.suvaraj.project1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="tbl_category")
@Data
@ToString
@NoArgsConstructor
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	
	/*
	 * @OneToMany(mappedBy = "category",cascade = CascadeType.ALL) private
	 * List<Product> products;
	 */
	
	public Category(String name)
	{
		this.name=name;
	}

	
}
