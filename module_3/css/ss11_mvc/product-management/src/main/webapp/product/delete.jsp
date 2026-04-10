<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting product</title>
</head>
<body>
<h1>Delete Product</h1>
<p>
    <a href="${pageContext.request.contextPath}/products"></a>
</p>
<form method="post" action="${pageContext.request.contextPath}/products">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="id" value="${requestScope["product"].getId()}">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product Information</legend>
        <table>
            <tr>
                <td>ID: </td>
                <td>${requestScope["product"].getId()}</td>
            </tr>
            <tr>
                <td>Name: </td>
                <td>${requestScope["product"].getName()}</td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>${requestScope["product"].getPrice()}</td>
            </tr>
            <tr>
                <td>Quantity: </td>
                <td>${requestScope["product"].getQuantity()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete product"></td>
                <td><a href="${pageContext.request.contextPath}/products"></a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
