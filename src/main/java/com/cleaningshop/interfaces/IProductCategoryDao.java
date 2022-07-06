package com.cleaningshop.interfaces;

import java.util.List;

import com.cleaningshop.model.ProductCategory;

public interface IProductCategoryDao {
	public List<ProductCategory> findAll();
}
