
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Update Product</title>
</head>
<body>
<h1>Update Product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="${pageContext.request.contextPath}/products">Back to product list </a>
</p>
<form method="post">
    <fieldset>
        <legend>Product Information</legend>
        <table>
            <tr>
                <td>ID:</td>
                <td><input type="text" name="id" id="id" value="${requestScope["product"].getId()}"></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${requestScope["product"].getName()}"></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name="price" id="price" value="${requestScope["product"].getPrice()}"></td>
            </tr>
            <tr>
                <td>Quantity: </td>
                <td><input type="text" name="quantity" id="quantity" value="${requestScope["product"].getQuantity()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update Product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
