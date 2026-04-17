<%--
  Created by IntelliJ IDEA.
  User: HAI DANG
  Date: 4/17/2026
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Product List</title>
</head>
<body>

<h2>Danh sách sản phẩm</h2>

<!-- Search -->
<form action="${pageContext.request.contextPath}/products" method="get">
  <input type="hidden" name="action" value="search"/>
  <input type="text" name="keyword" placeholder="Tìm kiếm..."/>
  <button type="submit">Search</button>
</form>

<br>

<a href="${pageContext.request.contextPath}/products?action=create">➕ Thêm sản phẩm</a>

<br><br>

<table border="1">
  <tr>
    <th>ID</th>
    <th>Tên</th>
    <th>Giá</th>
    <th>Số lượng</th>
    <th>Category ID</th>
    <th>Action</th>
  </tr>

  <c:forEach var="p" items="${products}">
    <tr>
      <td>${p.id}</td>
      <td>${p.name}</td>
      <td>${p.price}</td>
      <td>${p.quantity}</td>
      <td>${p.categoryId}</td>
      <td>
        <a href="${pageContext.request.contextPath}/products?action=edit&id=${p.id}">Edit</a>
        |
        <a href="${pageContext.request.contextPath}/products?action=delete&id=${p.id}"
           onclick="return confirm('Bạn có chắc muốn xoá?')">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>

<br>

<!-- Pagination -->
<a href="${pageContext.request.contextPath}/products?page=${currentPage - 1}">Prev</a> |
<a href="${pageContext.request.contextPath}/products?page=${currentPage + 1}">Next</a>

</body>
</html>
