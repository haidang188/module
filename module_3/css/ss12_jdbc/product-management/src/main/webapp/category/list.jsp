<%--
  Created by IntelliJ IDEA.
  User: HAI DANG
  Date: 4/17/2026
  Time: 4:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Category List</title>
</head>
<body>

<h2>Danh sách Category</h2>

<a href="${pageContext.request.contextPath}/categories?action=create">➕ Thêm category</a>

<br><br>

<table border="1">
  <tr>
    <th>ID</th>
    <th>Tên</th>
    <th>Action</th>
  </tr>

  <c:forEach var="c" items="${categories}">
    <tr>
      <td>${c.id}</td>
      <td>${c.name}</td>
      <td>
        <a href="${pageContext.request.contextPath}/categories?action=view&id=${c.id}">View</a>
        |
        <a href="${pageContext.request.contextPath}/categories?action=delete&id=${c.id}"
           onclick="return confirm('Xoá category?')">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>

<br>
<a href="${pageContext.request.contextPath}/products">⬅ Quay lại Product</a>

</body>
</html>
