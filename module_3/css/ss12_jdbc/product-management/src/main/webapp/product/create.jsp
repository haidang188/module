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
    <title>Create Product</title>
</head>
<body>

<h2>Thêm sản phẩm</h2>

<form action="${pageContext.request.contextPath}/products?action=create" method="post">

    Tên: <input type="text" name="name"/><br><br>

    Giá: <input type="text" name="price"/><br><br>

    Số lượng: <input type="text" name="quantity"/><br><br>

    Category:
    <select name="categoryId">
        <c:forEach var="c" items="${categories}">
            <option value="${c.id}">${c.name}</option>
        </c:forEach>
    </select>

    <br><br>

    <button type="submit">Create</button>

</form>

<br>
<a href="${pageContext.request.contextPath}/products">⬅ Quay lại</a>

</body>
</html>
