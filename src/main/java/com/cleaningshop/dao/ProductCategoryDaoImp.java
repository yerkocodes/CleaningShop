package com.cleaningshop.dao;

import java.util.ArrayList;
import java.util.List;

import com.cleaningshop.connection.ConnectionManager;
import com.cleaningshop.dto.ProductCategory;
import com.cleaningshop.interfaces.IProductCategoryDao;
import com.cleaningshop.model.Category;
import com.cleaningshop.model.Product;

public class ProductCategoryDaoImp extends ConnectionManager implements IProductCategoryDao {

	public ProductCategoryDaoImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ProductCategory> findAll() {
		List<ProductCategory> productsCategoriesList = new ArrayList<>();

		try {
			pstm = conn.prepareStatement("SELECT * FROM product INNER JOIN category on product.id_category = category.id_category");
			rs = pstm.executeQuery();

			while (rs.next()) {
				Product tempProduct = new Product();
				tempProduct.setId_product(rs.getInt("id_product"));
				tempProduct.setName_product(rs.getString("name_product"));
				tempProduct.setPrice_product(rs.getInt("price_product"));
				tempProduct.setDescription_product(rs.getString("description_product"));
				tempProduct.setId_category(rs.getInt("id_category"));
				
				Category tempCategory = new Category();
				tempCategory.setId_category(rs.getInt("id_category"));
				tempCategory.setName_category(rs.getString("name_category"));
				
				productsCategoriesList.add(new ProductCategory(tempProduct, tempCategory));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return productsCategoriesList;
	}

}
