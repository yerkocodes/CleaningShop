package com.cleaningshop.controllerServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cleaningshop.model.Category;
import com.cleaningshop.model.Product;
import com.cleaningshop.serviceFacade.Facade;

/**
 * Servlet implementation class EditProduct
 */
@WebServlet("/editProduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int idToFind = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Facade facade = new Facade();
		try {
			Product productToFind = facade.findProductById(Integer.parseInt(request.getParameter("id_product")));
			List<Category> listCategories = facade.findAllCategoryDao();
			if (!productToFind.getName_product().isEmpty()) {
				idToFind = Integer.parseInt(request.getParameter("id_product"));
				request.setAttribute("product", productToFind);
				request.setAttribute("categories", listCategories);
				request.getRequestDispatcher("editProduct.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher(""); // Servlet error
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Facade facade = new Facade();
		try {
			if (idToFind != 0) {
				Product productUpdated = facade.update(new Product(
					idToFind,
					request.getParameter("nameProduct"),
					Integer.parseInt(request.getParameter("priceProduct")),
					request.getParameter("descriptionProduct"), // description,
					Integer.parseInt(request.getParameter("categoryId")) // id Category
				));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
