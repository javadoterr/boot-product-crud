<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <!-- including common jsp page -->
    <%@ include file="./base.jsp" %>
  </head>
  <body>
    	<div class="container mt-5">
    		<div class="row">
    			<div class="col-md-6 offset-3">
    				<h4 class="text-center">Product List</h4>
    				<table class="table">
					  <thead class="table-dark">
					    <tr>
					      <th scope="col">Id</th>
					      <th scope="col">Product Name</th>
					      <th scope="col">Description</th>
					      <th scope="col">price</th>
					      <th scope="col">Action</th>
					    </tr>
					  </thead>
					  <tbody>
					  	<c:forEach items="${products}" var="product">
						    <tr>
						      <th scope="row">TECHONLY${product.id }</th>
						      <td>${product.name }</td>
						      <td>${product.description }</td>
						      <td>&#x20B9;${product.price }</td>
						      <td>
						      	<a href="${pageContext.request.contextPath}/delete-product/${product.id}">
						      					<i class="fa-solid fa-trash-can text-danger"></i></a>
						      	<a href="${pageContext.request.contextPath}/update-product/${product.id}">
						      				<i class="fa-regular fa-pen-to-square m-2"></i></a>
						      </td>
						    </tr>
					   </c:forEach>
					   
					  </tbody>
					</table>
					<div class="container text-center">
						<a href="${pageContext.request.contextPath}/add-product"
						       class="btn btn-outline-success">Add Product</a>
					</div>
    			</div>
    		</div>
    	</div>
    
  </body>
</html>