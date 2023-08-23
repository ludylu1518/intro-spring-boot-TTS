package com.tts.introToSpringBoot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String productName;
	private double productPrice;
	private String imageURL;
	
	public Product() {
		
	}
	
	public Product(Long id, String productName, double productPrice, String imageURL) {
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.imageURL = imageURL;
	}
	
	public String getImage() {
		return this.imageURL;
	}
	
	public void setImage(String image) {
		this.imageURL = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productPrice=" + productPrice + "]";
	}

	
}
