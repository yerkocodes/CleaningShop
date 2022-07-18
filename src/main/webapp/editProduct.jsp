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
		<h1>Edit Product: <c:out value="${product.getName_product()}"></c:out></h1>		
	</div>

	<!-- FORM -->
	<form class="container" action="editProduct" method="post">
		<div class="mb-3">
			<label for="nameProduct" class="form-label">Name</label> 
			<input type="text" class="form-control" id="nameProduct" name="nameProduct" value="${product.getName_product()}" required>
		</div>

		<div class="mb-3">
			<label for="priceProduct" class="form-label">Price</label> 
			<input type="number" class="form-control" id="priceProduct" name="priceProduct" value="${product.getPrice_product()}" required>
		</div>

		<div class="mb-3">
			<label for="descriptionProduct" class="form-label">Description</label> 
			<input type="text" class="form-control" id="descriptionProduct" name="descriptionProduct" value="${product.getDescription_product()}" required>
		</div>

		<div class="mb-3">
			<select class="form-select" name="categoryId"
				aria-label="Default select example" required>
				<c:forEach items="${categories}" var="temp">
					<c:if test="${temp.getId_category() == product.getId_category()}">
						<option selected value="${temp.getId_category()}">${temp.getName_category()}</option>
					</c:if>
					<c:if test="${temp.getId_category() != product.getId_category()}">
						<option value="${temp.getId_category()}">${temp.getName_category()}</option>
					</c:if>
				</c:forEach>
			</select>
		</div>

		<button type="submit" class="btn btn-primary">Add Product</button>
	</form>

</body>
</html>