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
 * Servlet implementation class AddProduct
 */
@WebServlet("/addProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Facade facade = new Facade();
		List<Category> listCategories = facade.findAllCategoryDao();

		request.setAttribute("categories", listCategories);
		
		request.getRequestDispatcher("addProduct.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Facade facade = new Facade();

		try {
			Product productToAdd = new Product(
				0,
				request.getParameter("nameProduct"),
				Integer.parseInt(request.getParameter("priceProduct")),
				request.getParameter("descriptionProduct"),
				Integer.parseInt(request.getParameter("categoryId"))	
			);
			
			Product productAdded = facade.add(productToAdd);
			
			if (productAdded.getId_product() != 0) {
				request.setAttribute("productAdded", productAdded);
				request.setAttribute("modifier", "added");
				request.getRequestDispatcher("productAddedOK.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
