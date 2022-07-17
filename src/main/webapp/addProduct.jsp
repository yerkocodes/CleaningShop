<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add new product</title>
<jsp:include page="layouts/headResources.html"></jsp:include>
</head>
<body>
	<jsp:include page="layouts/navbar.html"></jsp:include>

	<div class="container text-center my-5">
		<h1>Add Product</h1>		
	</div>

	<!-- FORM -->
	<form class="container" action="/addProduct" method="post">
		<div class="mb-3">
			<label for="nameProduct" class="form-label">Name</label> 
			<input type="text" class="form-control" id="nameProduct" name="nameProduct" required>
		</div>

		<div class="mb-3">
			<label for="priceProduct" class="form-label">Price</label> 
			<input type="number" class="form-control" id="priceProduct" name="priceProduct" required>
		</div>

		<div class="mb-3">
			<label for="descriptionProduct" class="form-label">Description</label> 
			<input type="text" class="form-control" id="descriptionProduct" name="descriptionProduct" required>
		</div>

		<div class="mb-3">
			<select class="form-select" aria-label="Default select example">
				<option selected disabled>default option</option>
				<c:forEach items="${categories}" var="temp">
					<%-- 					
					<option value="temp.getId_product()">${temp.getName_product()}</option>
 --%>
					<option value="">${temp.getName_category()}</option>
					<p>${temp}</p>
				</c:forEach>
			</select>
		</div>

		<button type="submit" class="btn btn-primary">Add Product</button>
	</form>

</body>
</html>