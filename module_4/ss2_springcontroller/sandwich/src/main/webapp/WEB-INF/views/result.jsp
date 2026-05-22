<%--
  Created by IntelliJ IDEA.
  User: HAI DANG
  Date: 5/22/2026
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h1>Selected Condiments</h1>
<ul>
    <c:forEach var="item" items="${condiments}">
        <li>${item}</li>
    </c:forEach>
</ul>
</body>
</html>
