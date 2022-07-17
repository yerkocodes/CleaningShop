<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="layouts/headResources.html"></jsp:include>
</head>
<body>
	<jsp:include page="layouts/navbar.html"></jsp:include>
	<h1>Product added successfully</h1>
	<button>
		<a href="addProduct">Add other product</a>
	</button>
	<button>
		<a href="productsList">List of products</a>
	</button>
</body>
</html>