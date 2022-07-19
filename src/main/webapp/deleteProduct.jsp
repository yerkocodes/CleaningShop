<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
		<h1>Are you sure to delete this product:</h1>
	</div>

	<!-- FORM -->
	<section class="container mx-auto">
		<form class="row g-3 needs-validation" action="deleteProduct" method="post" validate>
			<div class="col-md-4">
				<label for="validationCustom01" class="form-label">Name product</label> 
					<input type="text" class="form-control" id="validationCustom01" value="${productToDelete.getName_product()}" disabled>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="col-md-4">
				<label for="validationCustom02" class="form-label">Category</label>
				<input type="text" class="form-control" id="validationCustom02" value="${category.getName_category()}" disabled>
				<div class="valid-feedback">Looks good!</div>
			</div>
			<div class="col-md-4">
				<label for="validationCustom02" class="form-label">Price</label> 
				<input type="text" class="form-control" id="validationCustom02" value="$ ${productToDelete.getPrice_product()}" disabled>
				<div class="valid-feedback">Looks good!</div>
			</div>

			<div class="col-md-6">
				<label for="validationCustom02" class="form-label">Description</label>
				<input type="text" class="form-control" id="validationCustom02" value="${productToDelete.getDescription_product()}" disabled>
				<div class="valid-feedback">Looks good!</div>
			</div>

			<div class="col-md-6">
				<label for="validationCustom04" class="form-label">Delete product</label> 
					<select class="form-select" id="validationCustom04" name="selectConfirm" required>
					<option selected disabled value="">Select an option...</option>
					<option value="yes">Yes</option>
					<option value="no">No</option>
				</select>
				<div class="invalid-feedback">Please select a valid state.</div>
			</div>

			<div class="col-12">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="" id="invalidCheck" required> 
					<label class="form-check-label" for="invalidCheck">I agree to permanently delete this product </label>
					<div class="invalid-feedback">You must agree before submitting.</div>
				</div>
			</div>
			<div class="col-12">
				<button class="btn btn-primary" type="submit">Delete</button>
			</div>
		</form>
	</section>


	<%-- 	
	<form class="container text-center" action="deleteProduct" method="post">
		<div class="row my-3">
			<div class="col-sm-12 col-md-12 col-lg-4 col-xl-4 col-xxl-4 mx-auto">
				<ul class="list-group mb-3">
					<li class="list-group-item">Product name: <c:out value="${productToDelete.getName_product()}"></c:out></li>
					<li class="list-group-item">Category: <c:out value="${category.getName_category()}"></c:out></li>
					<li class="list-group-item">Description: <c:out value="${productToDelete.getDescription_product()}"></c:out></li>
					<li class="list-group-item">Price: <c:out value="${productToDelete.getPrice_product()}"></c:out></li>
 				</ul>
				<select class="form-select" name="categoryId" aria-label="Default select example" required>
					<option selected disabled>Select an option</option>
					<option value="">yes</option>
					<option value="">no</option>
				</select>
			</div>
		</div>

		<button type="submit" class="btn btn-primary">Delete Product</button>
	</form>
 --%>

</body>
</html>