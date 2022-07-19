package com.cleaningshop.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

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
//		INSERT INTO product (name_product, price_product, description_product, id_category) VALUES ('Omo', 3500, 'Quita manchas', (SELECT id_category FROM category WHERE name_category = 'Detergente líquido'));

		try {

			pstm = conn.prepareStatement(
					"INSERT INTO product (name_product, price_product, description_product, id_category) VALUES (?, ?, ?, ?)");
			pstm.setString(1, product.getName_product());
			pstm.setInt(2, product.getPrice_product());
			pstm.setString(3, product.getDescription_product());
			pstm.setInt(4, product.getId_category());

			if (pstm.executeUpdate() == 1) {
				product.setId_product(findLastId());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}

	@Override
	public Product updateProduct(Product product) {
		// UPDATE table_name SET column1 = value1, column2 = value2, ... WHERE
		// condition;
		// UPDATE product SET name_product = 'Quix', price_product = 1000,
		// description_product = 'El mejor', id_category = 1 WHERE id_product = 2;
		try {
			pstm = conn.prepareStatement(
					"UPDATE product SET name_product = ?, price_product = ?, description_product = ?, id_category = ? WHERE id_product = ?");
			pstm.setString(1, product.getName_product());
			pstm.setInt(2, product.getPrice_product());
			pstm.setString(3, product.getDescription_product());
			pstm.setInt(4, product.getId_category());
			pstm.setInt(5, product.getId_product());

			if (pstm.executeUpdate() == 1) {
				return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Product();
	}

	@Override
	public boolean deleteProduct(int id) {
//		DELETE FROM product WHERE id_producto = ?;
		boolean result = false;
		try {
			pstm = conn.prepareStatement("DELETE FROM product WHERE id_product = ?");
			pstm.setInt(1, id);

			if (pstm.executeUpdate() == 1) {
				result = true;
			} else {
				result = false;
				throw new RuntimeException("A delete error has ocurred in the database");
			}

		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int findLastId() {
		int result = 0;
		try {
			pstm = conn.prepareStatement("SELECT MAX(id_product) FROM product");
			rs = pstm.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
				return result;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
