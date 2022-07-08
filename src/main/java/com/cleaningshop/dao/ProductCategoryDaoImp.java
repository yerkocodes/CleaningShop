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
	
	
	// ----------------------------------------
//	ProductoCategoriaDaoImp extends AdministradorConexion implements ProductoCategoriaDao {
//	    
//	    public ProductoCategoriaDaoImp() {
//	        conn = generaPoolConexion();
//	    }
//	    
//	    @Override //SELECT * FROM PRODUCTO PRO INNER JOIN CATEGORIA CAT ON CAT.ID_CATEGORIA = PRO.ID_CATEGORIA
//	    public List<ProductoCategoria> findAll() {
//	        
//	        ProductoDao productoDao = new ProductoDaoImp();
//	        CategoriaDao categoriaDao = new CategoriaDaoImp();
//	        
//	        List<ProductoCategoria> listaProductoCategoria = new ArrayList<ProductoCategoria>();
//	        
//	        for (Producto productoTemp : productoDao.findAll()) {
//	            
//	            ProductoCategoria productoCategoria = new ProductoCategoria();//objeto ProductoCagoria que se agregara a la lista
//	            
//	            //buscando la categoria del objeto temporal encontrado mediante el metodo findAll() que retorna una lista de Producto
//	            Categoria categoria = categoriaDao.findById(productoTemp.getIdCategoria()); //mediante el id del productoTemp, se busca la categoria
//	            
//	            productoCategoria.setProducto(productoTemp);//se setea el producto en productoCategoria
//	            productoCategoria.setCategoria(categoria);
//	            
//	            listaProductoCategoria.add(productoCategoria);
//	        }
//	        
//	        return listaProductoCategoria;
//	    }
//	}
	// ----------------------------------------

}
