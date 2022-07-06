package com.cleaningshop.interfaces;

import java.util.List;

import com.cleaningshop.model.Category;

public interface ICategoryDao {
	public Category findById(int id);
	public List<Category> findAll();
}
