package com.cleaningshop.model;

public class Category {
	private int id_category;
	private String name_category;
	
	public Category() {}

	public Category(int id_category, String name_category) {
		super();
		this.id_category = id_category;
		this.name_category = name_category;
	}

	public int getId_category() {
		return id_category;
	}

	public void setId_category(int id_category) {
		this.id_category = id_category;
	}

	public String getName_category() {
		return name_category;
	}

	public void setName_category(String name_category) {
		this.name_category = name_category;
	}

	@Override
	public String toString() {
		return "Category [id_category=" + id_category + ", name_category=" + name_category + "]";
	}
	
}
