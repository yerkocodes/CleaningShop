package com.cleaningshop.interfaces;

import java.util.List;

import com.cleaningshop.model.Product;

public interface IProductDao {
	public Product findById(int id);
	public List<Product> findAll();
	public Product addProduct(Product product);
	public Product updateProduct(Product product);
	public boolean deleteProduct(int id);
	public int findLastId();
}
