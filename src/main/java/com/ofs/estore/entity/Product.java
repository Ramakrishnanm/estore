package com.ofs.estore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	@Size(max = 100)
	private String name;

	@NotNull
	private double unitPrice;
	
	@NotNull
	private int unitCount;
	
	@ManyToOne
	private ProductCategory productCategory;

	public Product() {
	}

	public Product(String name, double unitPrice, ProductCategory productCategory, int unitCount) {
		this.name = name;
		this.unitPrice = unitPrice;
		this.productCategory = productCategory;
		this.unitCount = unitCount; 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public int getUnitCount() {
		return unitCount;
	}

	public void setUnitCount(int unitCount) {
		this.unitCount = unitCount;
	}
}
