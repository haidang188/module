<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product</h1>
<p>
    <a href="${pageContext.request.contextPath}/products?action=create">Create new product</a>
    
</p>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Price</td>
        <td>Quantity</td>
        <td>Action</td>
    </tr>
    
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <td>${product.id}</td>
            <td>
                <a href="${pageContext.request.contextPath}/products?action=view&id=${product.id}">${product.name}</a>
            </td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td>
                <a href="${pageContext.request.contextPath}/products?action=update&id=${product.id}">
                    Update
                </a>
            </td>
            <td>
            <td>
                <a href="${pageContext.request.contextPath}/products?action=delete&id=${product.id}">
                    Delete
                </a>
            </td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
