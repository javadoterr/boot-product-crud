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
    				<h3 class="text-center mb-3"> Fill the Product Details :</h3>
    				<form action="handle-product" method="post">
    					 <div class="mb-3">
						    <label for="name" class="form-label">Product Name</label>
						    <input type="text" class="form-control" id="name" name="name" aria-describedby="nameHelp">
						 </div>
						 <div class="mb-3">
						    <label for="description" class="form-label">Product Description</label>
						    <textarea class="form-control" placeholder="Enter the product description" id="description" name="description" style="height: 100px"></textarea>
						 </div>
						 <div class="mb-3">
						    <label for="price" class="form-label">Product price</label>
						    <input type="text" class="form-control" id="price" name="price" aria-describedby="priceHelp">
						 </div>
						 <div class="container text-center">
						 	<a href="${pageContext.request.contextPath}/" class="btn btn-outline-danger">Back</a>
						 	<button type="submit" class="btn btn-primary">Add</button>
						 </div>						  
    				</form>
    			</div>
    		</div>
    	</div>
    
  </body>
</html>