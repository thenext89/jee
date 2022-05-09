<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page = "_header.jsp"></jsp:include>
	<jsp:include page = "_menu.jsp"></jsp:include>
	<h3 style = "color:blue">Create Product</h3>
	<p style = "color:red">${errorString}</p>
	<form method = "POST" action = "${pageContext.request.contextPath}/createProduct">
		<table>
		<tr>
			<td>code: </td>
			<td><input type = "text" name = "code" value = "${product.code}"></input></td>
		</tr>
		<tr>
			<td>name: </td>
			<td><input type = "text" name ="name" value = "${product.name}"></input></td>
		</tr>
		<tr>
			<td>price: </td>
			<td><input type = "text" name = "price" value = "${product.price}"></input></td>
		</tr>
		<tr>
			<td>
			<input type = "submit" value = "submit"></input>
			</td>
			<td><a href="productList">cancel</a></td>
		</tr>
		</table>
	</form>
	<jsp:include page = "_footer.jsp"></jsp:include>
</body>
</html>