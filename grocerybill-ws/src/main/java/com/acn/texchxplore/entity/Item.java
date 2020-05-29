package com.acn.texchxplore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;

	private double price;

	private boolean discounted;

	private double discountPercentage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item() {

	}

	public Item(String name, double price, boolean discounted, double discountPercentage) {

		this.name = name;
		this.price = price;
		this.discounted = discounted;
		this.discountPercentage = discountPercentage;

	}

	public String getName() {
		return name;

	}

	public void setName(String name) {
		this.name = name;

	}

	public double getPrice() {
		return price;

	}

	public void setPrice(double price) {
		this.price = price;

	}

	public boolean isDiscounted() {
		return discounted;
	}

	public double getDiscountPercentage() {
		return discountPercentage;

	}

	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;

	}
}
