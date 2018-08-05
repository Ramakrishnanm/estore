package com.ofs.estore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class ProductCategory {

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	@Size(max = 50)
	private String name;

	private boolean isDiscountApplicable;

	public ProductCategory() {
	}

	public ProductCategory(String name, boolean isDiscountApplicable) {
		this.name = name;
		this.isDiscountApplicable = isDiscountApplicable;
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

	public boolean isDiscountApplicable() {
		return isDiscountApplicable;
	}

	public void setDiscountApplicable(boolean isDiscountApplicable) {
		this.isDiscountApplicable = isDiscountApplicable;
	}
}
