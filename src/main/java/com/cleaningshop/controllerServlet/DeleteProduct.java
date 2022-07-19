package com.cleaningshop.controllerServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cleaningshop.model.Category;
import com.cleaningshop.model.Product;
import com.cleaningshop.serviceFacade.Facade;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/deleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int idToDelete = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Facade facade = new Facade();
		idToDelete = Integer.parseInt(request.getParameter("id_product"));
		try {
			Product productToDelete = facade.findProductById(idToDelete);
			if (productToDelete.getName_product() != null) {
				Category category = facade.findCategoryByid(productToDelete.getId_category());
				request.setAttribute("category", category);
				request.setAttribute("productToDelete", productToDelete);
				request.getRequestDispatcher("deleteProduct.jsp").forward(request, response); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Facade facade = new Facade();
		try {
			if (request.getParameter("selectConfirm").equals("yes")) {
				boolean deleteConfirm = facade.delete(idToDelete);
				request.setAttribute("modifier", "deleted");
				request.getRequestDispatcher("productAddedOK.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("productList.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
