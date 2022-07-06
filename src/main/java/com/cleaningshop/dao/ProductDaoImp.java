package com.cleaningshop.dao;

import java.util.ArrayList;
import java.util.List;

import com.cleaningshop.connection.ConnectionManager;
import com.cleaningshop.interfaces.IProductDao;
import com.cleaningshop.model.Product;

public class ProductDaoImp extends ConnectionManager implements IProductDao {

	public ProductDaoImp() {
		conn = generateConnection();
	}

	@Override
	public Product findById(int id) {
		return null;
	}

	@Override
	public List<Product> findAll() {
		
		List<Product> productsList = new ArrayList<>();
		
		try {
			pstm = conn.prepareStatement("SELECT * FROM product");
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Product tempProduct = new Product();
				tempProduct.setId_product(rs.getInt("id_product"));
				tempProduct.setName_product(rs.getString("name_product"));
				tempProduct.setPrice_product(rs.getInt("price_product"));
				tempProduct.setDescription_product(rs.getString("description_product"));
				tempProduct.setId_category(rs.getInt("id_category"));
				
				productsList.add(tempProduct);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return productsList;
	}

	@Override
	public Product addProduct(Product product) {
		return null;
	}

	@Override
	public Product updateProduct(Product product) {
		return null;
	}

	@Override
	public boolean deleteProduct(int id) {
		return false;
	}

	@Override
	public int findLastId() {
		return 0;
	}

}
