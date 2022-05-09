<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page = "_header.jsp"></jsp:include>
	<jsp:include page = "_menu.jsp"></jsp:include>
	<h3 style ="color:blue"> Edit Product</h3>
	<form method = "POST" action = "${pageContext.request.contextPath}/editProduct">
		<input type="hidden" name = "code" value = "${product.code}"></input>
		<table>
			<tr>
                  <td>Code</td>
                  <td style="color:red;">${product.code}</td>
               </tr>
               <tr>
                  <td>Name</td>
                  <td><input type="text" name="name" value="${product.name}" /></td>
               </tr>
               <tr>
                  <td>Price</td>
                  <td><input type="text" name="price" value="${product.price}" /></td>
               </tr>
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/productList">Cancel</a>
                  </td>
               </tr>
		</table>
	</form>
	<jsp:include page = "_footer.jsp"></jsp:include>
</body>
</html>