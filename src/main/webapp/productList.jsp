<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="layouts/headResources.html"></jsp:include>
</head>
<body>
	<jsp:include page="layouts/navbar.html"></jsp:include>

	<div class="container text-center my-5">
		<h1>List of products</h1>
	</div>

	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID Poduct</th>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Description</th>
					<th scope="col">Price</th>
					<th scope="col">Modifiers</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productCategoryList}" var="item">
					<tr>
						<td><c:out value="${item.getProduct().getId_product()}"></c:out></td>
						<%-- <th scope="row"> <c:out value="${item.getProduct()}"></c:out></th> --%>
						<td><c:out value="${item.getProduct().getName_product()}"></c:out></td>
						<td><c:out value="${item.getCategory().getName_category()}"></c:out></td>
						<td><c:out
								value="${item.getProduct().getDescription_product()}"></c:out></td>
						<td>$ <c:out value="${item.getProduct().getPrice_product()}"></c:out></td>
						<td>
							<button class="mx-1">
								<a href="editProduct?id_product=${item.getProduct().getId_product()}">Edit</a>
							</button>
							<button class="mx-1">
								<a href="deleteProduct?id_product=${item.getProduct().getId_product()}">Delete</a>
							</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>