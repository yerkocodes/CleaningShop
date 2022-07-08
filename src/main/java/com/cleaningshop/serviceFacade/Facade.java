package com.cleaningshop.serviceFacade;

import java.util.List;

import com.cleaningshop.dao.CategoryDaoImp;
import com.cleaningshop.dao.ProductCategoryDaoImp;
import com.cleaningshop.dao.ProductDaoImp;
import com.cleaningshop.dto.ProductCategory;
import com.cleaningshop.interfaces.ICategoryDao;
import com.cleaningshop.interfaces.IProductCategoryDao;
import com.cleaningshop.interfaces.IProductDao;
import com.cleaningshop.model.Category;
import com.cleaningshop.model.Product;

public class Facade {
	
	private IProductDao iProductDao = new ProductDaoImp();
	private ICategoryDao iCategoryDao = new CategoryDaoImp();
	private IProductCategoryDao iProductCategoryDao = new ProductCategoryDaoImp();
	
	// ProductDao
	public Product findById(int id) {
		return iProductDao.findById(id);
	}
	
	public List<Product> findAllProductDao() {
		return iProductDao.findAll();
	}

	public Product add(Product product) {
		return iProductDao.addProduct(product);
	}

	public Product update(Product product) {
		return iProductDao.updateProduct(product);
	}

	public boolean delete(int id) {
		return iProductDao.deleteProduct(id);
	}

	public int findLastId() {
		return iProductDao.findLastId();
	}
	
	// CategoryDao
	public Category findByid(int id) {
		return iCategoryDao.findById(id);
	}

	public List<Category> findAllCategoryDao() {
		return iCategoryDao.findAll();
	}
	
	// ProductCategoryDao
	public List<ProductCategory> findAllProductCategoryDao() {
		return iProductCategoryDao.findAll();
	}
}
