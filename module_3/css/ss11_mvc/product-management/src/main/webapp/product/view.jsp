<%--
  Created by IntelliJ IDEA.
  User: HAI DANG
  Date: 4/10/2026
  Time: 8:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
</head>
<body>
<h1>Product details</h1>
<p>
  <a href="${pageContext.request.contextPath}/products">Back to product list</a>

</p>
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
</table>

</body>
</html>
