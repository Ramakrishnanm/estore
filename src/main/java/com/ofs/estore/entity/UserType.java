package com.ofs.estore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class UserType {

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	@Size(max = 20)
	private String name;
	
	@NotNull
	private double discountPercentage;

	public static enum TYPES {

		EMPLOYEE("employee"), AFFLIATE("affliate");

		private String value;

		private TYPES(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}

	public UserType() {
	}

	public UserType(String name, double discountPercentage) {
		this.name = name;
		this.discountPercentage = discountPercentage;
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

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
}
