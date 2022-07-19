package com.cleaningshop.dao;

import java.util.ArrayList;
import java.util.List;

import com.cleaningshop.connection.ConnectionManager;
import com.cleaningshop.interfaces.ICategoryDao;
import com.cleaningshop.model.Category;

public class CategoryDaoImp extends ConnectionManager implements ICategoryDao {

	public CategoryDaoImp() {
	}

	@Override
	public Category findById(int id) {
		Category category = new Category();

		try {
			pstm = conn.prepareStatement("SELECT * FROM category WHERE category.id_category= ?");
			pstm.setInt(1, id);
			rs = pstm.executeQuery();

			if (rs.next()) {
				category.setId_category(rs.getInt("id_category"));
				category.setName_category(rs.getString("name_category"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return category;
	}

	@Override
	public List<Category> findAll() {
		
		List<Category> categoriesList = new ArrayList<>();

		try {
			pstm = conn.prepareStatement("SELECT * FROM category");
			rs = pstm.executeQuery();

			while (rs.next()) {
				Category tempCategory = new Category();
				tempCategory.setId_category(rs.getInt("id_category"));
				tempCategory.setName_category(rs.getString("name_category"));

				categoriesList.add(tempCategory);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return categoriesList;
	}

}
