package com.cleaningshop.model;

public class Product {

	private int id_product;
	private String name_product;
	private int price_product;
	private String description_product;
	private int id_category;
	
	public Product() {}

	public Product(int id_product, String name_product, int price_product, String description_product,
			int id_category) {
		super();
		this.id_product = id_product;
		this.name_product = name_product;
		this.price_product = price_product;
		this.description_product = description_product;
		this.id_category = id_category;
	}

	public int getId_product() {
		return id_product;
	}

	public void setId_product(int id_product) {
		this.id_product = id_product;
	}

	public String getName_product() {
		return name_product;
	}

	public void setName_product(String name_product) {
		this.name_product = name_product;
	}

	public int getPrice_product() {
		return price_product;
	}

	public void setPrice_product(int price_product) {
		this.price_product = price_product;
	}

	public String getDescription_product() {
		return description_product;
	}

	public void setDescription_product(String description_product) {
		this.description_product = description_product;
	}

	public int getId_category() {
		return id_category;
	}

	public void setId_category(int id_category) {
		this.id_category = id_category;
	}

	@Override
	public String toString() {
		return "Product [id_product=" + id_product + ", name_product=" + name_product + ", price_product="
				+ price_product + ", description_product=" + description_product + ", id_category=" + id_category + "]";
	}
	
	
	
	
}
