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
		
		Product product = new Product();
		
		try {
			pstm = conn.prepareStatement("SELECT * FROM product WHERE product.id_product = ?");
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				product.setId_product(rs.getInt("id_product"));
				product.setName_product(rs.getString("name_product"));
				product.setPrice_product(rs.getInt("price_product"));
				product.setDescription_product(rs.getString("description_product"));
				product.setId_category(rs.getInt("id_category"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return product;
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
