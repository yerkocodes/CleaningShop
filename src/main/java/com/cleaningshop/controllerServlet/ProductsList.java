package com.cleaningshop.controllerServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cleaningshop.dto.ProductCategory;
import com.cleaningshop.serviceFacade.Facade;

/**
 * Servlet implementation class ProductsList
 */
@WebServlet("/productsList")
public class ProductsList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Facade facade = new Facade();
		
		List<ProductCategory> productCategoryList = facade.findAllProductCategoryDao();

		request.setAttribute("productCategoryList", productCategoryList);
		request.getRequestDispatcher("productList.jsp").forward(request, response);

		System.out.println("HOLAAAA" + productCategoryList);
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
