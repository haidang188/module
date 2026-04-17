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
    <title>Edit Product</title>
</head>
<body>

<h2>Sửa sản phẩm</h2>

<form action="${pageContext.request.contextPath}/products?action=edit" method="post">

    <input type="hidden" name="id" value="${product.id}"/>

    Tên:
    <input type="text" name="name" value="${product.name}"/><br><br>

    Giá:
    <input type="text" name="price" value="${product.price}"/><br><br>

    Số lượng:
    <input type="text" name="quantity" value="${product.quantity}"/><br><br>

    Category:
    <select name="categoryId">
        <c:forEach var="c" items="${categories}">
            <option value="${c.id}"
                    <c:if test="${c.id == product.categoryId}">selected</c:if>>
                    ${c.name}
            </option>
        </c:forEach>
    </select>

    <br><br>

    <button type="submit">Update</button>

</form>

<br>
<a href="${pageContext.request.contextPath}/products">⬅ Quay lại</a>

</body>
</html>
