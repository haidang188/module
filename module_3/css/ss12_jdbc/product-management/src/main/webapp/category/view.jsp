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
  <title>Category Detail</title>
</head>
<body>

<h2>Category & Products</h2>

<c:forEach var="c" items="${categories}">
  <h3>${c.name}</h3>

  <c:forEach var="p" items="${categoryProducts[c.id]}">
    <p> - ${p.name} (${p.price})</p>
  </c:forEach>

</c:forEach>

<br>
<a href="${pageContext.request.contextPath}/categories">⬅ Quay lại</a>

</body>
</html>
